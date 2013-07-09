#=====================================================================================
#  TimeStep must be monthly 
#=====================================================================================

import os
from scripts.wrims2.study import Study
from scripts.tool import LogUtils, Param, LookupTable, FileUtils, DssVista

# User Input
########################################################
svarOriginalFile="studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_SV.dss"
svarNewFile = "studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_PA_SV.dss"
runDir = "studies/callite_D1641Existing_PA__2012oct/Run"
lookupOriginalDir = os.path.join(runDir, "Lookup", "PA_Base_D1641_Existing" )
futureWY = 2013
historyWYs = [1935, 1970, 1988]
sequentialYRs = 2   # including first year

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



# initialization
Param.mainScriptPath = __file__
LogUtils.initLogging()



for beginWY in historyWYs:

    endWY = beginWY + sequentialYRs - 1
    # dir for outTable, e.g., PA_1945_1947
    outSubDir = "PA_"+str(beginWY)+"_"+str(endWY)

# prepare tables

    # delete outSubDir content    
    FileUtils.erase( os.path.join(runDir, "Lookup", outSubDir))

    # copy all tables from LookupOriginalDir to outSubDir
    FileUtils.copyAll(lookupOriginalDir, os.path.join(runDir, "Lookup", outSubDir))

    # create lookup table for converting futureWaterYear to historicalWaterYear
    posTable = open(os.path.join(runDir, "Lookup", outSubDir,"Position_Analysis.table"),'w+'  )
    posTable.write("Position_Analysis\n")
    posTable.write("FutureWaterYear     HistoricalWaterYear\n")
    for iYear in range(sequentialYRs):
        posTable.write(str(futureWY+iYear)+"\t"+str(beginWY+iYear)+'\n')
    posTable.close()
    

    for tableName in yearlyTableList:
        outTablePath = os.path.join(runDir, "Lookup", outSubDir, tableName)
        inTablePath = os.path.join(lookupOriginalDir, tableName)
    
        LookupTable.copyYearlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)


    for tableName in monthlyTableList:
        
        outTablePath = os.path.join(runDir, "Lookup", outSubDir, tableName)
        inTablePath = os.path.join(lookupOriginalDir, tableName)
    
        LookupTable.copyMonthlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)



# prepare svar file

    outSvarFpart = str(beginWY)+"_"+str(endWY) # e.g., 1945_1947
    studyName = 'PA_'+outSvarFpart

    DssVista.copyDssToFuture_waterYear(svarOriginalFile, svarNewFile, beginWY, sequentialYRs, futureWY, outSvarFpart)    
    DssVista.array2dss(svarNewFile, UARM_at_2012_09, "30SEP2012 2400", "/CALLITE/UARM/STORAGE//1MON/"+ outSvarFpart +"/", "TAF")



# prepare config and batch files

    s = Study("studies/callite_D1641Existing_PA__2012oct/PA_template.config")
    s.setConfig(studyName, StartYear=2012, SvarFPart=outSvarFpart, LookupSubDir=studyName)
    s.writeBatch(pause=True)


