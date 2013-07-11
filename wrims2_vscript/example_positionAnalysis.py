#=====================================================================================
#  TimeStep must be monthly 
#=====================================================================================

from os import path 
from scripts.wrims2.study import Study
from scripts.wrims2.runGroup import RunGroup
from scripts.tool import LogUtils, Param, LookupTable, FileUtils, DssVista

## Step 1. 
## Step 2.


# User Input
########################################################

# projectName will be used to prepend generated files and folders.
projectName ="CalLitePA_demo"

# path to this script and its directory
Param.mainScriptPath = path.abspath(__file__)
Param.mainScriptDir  = path.dirname(Param.mainScriptPath)

# studyRunDir is the run directory of the CalLite study
studyRunDir = path.join(Param.mainScriptDir, "studies/callite_D1641Existing_PA__2012oct/Run")

svarOriginalFile =path.join(studyRunDir, "DSS/CL_EXISTING_BO_081011_SV.dss")
#svarNewFile      =path.join(studyRunDir, "DSS/CL_EXISTING_BO_081011_PA_SV.dss")

lookupOriginalDir = path.join(studyRunDir, "Lookup", "PA_Base_D1641_Existing" )
futureWY = 2013
historyWYs = [ x for x in range(1935, 1937)]
sequentialYRs = 1   # including first year
simultaneousRuns = 4 # how many runs at the same time

# UARM: Upper American River Model, that is storage in French Meadows, 
# Hell Hole, and Union Valley Reservoirs, which are upstream of Folsom.
# Tom Fitzhugh 

UARM_at_2012_09 = [300] 

yearlyTableList = ["wytypes.table",
                   "wytypesjr.table",
                   "wytypeD1485.table",
                   "wytypeDefic.table",
                   "wytypeSnow.table",
                   "AnnualReqDel_swp.table",
                   "SacValleyIndex.table",
                   "eightriver.table",
                   "FWS_BO_A3_Temp.table",
                   "wheelCap.table",
                   "sacramento_runoff_forecast.table",
                   "american_runoff_forecast.table",
                   "febeiratio.table",
                   "delta_index.table",
                ]

monthlyTableList = ["feather_runoff_forecast.table",
                    "x2days.table",
                ]
########################################################
svarNewFile      =path.join(studyRunDir, "DSS/CL_EXISTING_BO_081011_PA_SV.dss")


SvarFile = path.relpath(svarNewFile, path.dirname(studyRunDir))



########################################################

# initialization
Param.mainScriptPath = path.normpath(path.abspath(__file__))
LogUtils.initLogging()
runGroup = RunGroup(projectName)


for beginWY in historyWYs:

    endWY = beginWY + sequentialYRs - 1
    # dir for outTable, e.g., PA_1945_1947
    outSubDir = projectName+"_"+str(beginWY)+"_"+str(endWY)

# prepare tables

    # delete outSubDir content    
    FileUtils.erase( path.join(studyRunDir, "Lookup", outSubDir))

    # copy all tables from LookupOriginalDir to outSubDir
    FileUtils.copyAll(lookupOriginalDir, path.join(studyRunDir, "Lookup", outSubDir))

    # create lookup table for converting futureWaterYear to historicalWaterYear
    posTable = open(path.join(studyRunDir, "Lookup", outSubDir,"Position_Analysis.table"),'w+'  )
    posTable.write("Position_Analysis\n")
    posTable.write("FutureWaterYear     HistoricalWaterYear\n")
    for iYear in range(sequentialYRs):
        posTable.write(str(futureWY+iYear)+"\t"+str(beginWY+iYear)+'\n')
    posTable.close()
    

    for tableName in yearlyTableList:
        outTablePath = path.join(studyRunDir, "Lookup", outSubDir, tableName)
        inTablePath = path.join(lookupOriginalDir, tableName)
    
        LookupTable.copyYearlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)


    for tableName in monthlyTableList:
        
        outTablePath = path.join(studyRunDir, "Lookup", outSubDir, tableName)
        inTablePath = path.join(lookupOriginalDir, tableName)
    
        LookupTable.copyMonthlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)



# prepare svar file

    outSvarFpart = str(beginWY)+"_"+str(endWY) # e.g., 1945_1947
    studyName = projectName+'_'+outSvarFpart

    DssVista.copyDssToFuture_waterYear(svarOriginalFile, svarNewFile, beginWY, sequentialYRs, futureWY, outSvarFpart)    
    DssVista.array2dss(svarNewFile, UARM_at_2012_09, "30SEP2012 2400", "/CALLITE/UARM/STORAGE//1MON/"+ outSvarFpart +"/", "TAF")



# prepare config and batch files

    s = Study("studies/callite_D1641Existing_PA__2012oct/PA_template.config")
    s.setConfig(studyName, StartYear=2012, SvarFile=SvarFile, SvarFPart=outSvarFpart, NumberOfSteps=sequentialYRs*12, LookupSubDir=studyName)
    s.writeBatch(pause=False)
    runGroup.add(s)

# write batch for all runs
runGroup.writeBatch(simultaneousRuns)
