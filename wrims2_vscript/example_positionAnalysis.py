#=====================================================================================
#  TimeStep must be monthly 
#=====================================================================================

import os
import scripts.tool.DssVista as DV
from scripts.wrims2.study import Study
from scripts.tool import LogUtils, Param
from scripts.tool import LookupTable
from scripts.tool import FileUtils

# User Input
#-------------------------------------------------------------------------------
inFile="studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_SV.dss"
outFile = "studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_PA_SV.dss"
futureWY = 2013
historyWYs = [1935, 1970, 1988]
sequentialYRs = 2   # including first year

# UARM: Upper American River Model, that is storage in French Meadows, 
# Hell Hole, and Union Valley Reservoirs, which are upstream of Folsom.
# Tom Fitzhugh 

UARM_at_2012_09 = [300] 
#--------------------------------------------------------------------------------
#-------------------------------------------------------------------------------
lookupPath = "studies/callite_D1641Existing_PA__2012oct/Run/Lookup"
inSubDir = "PA_Base_D1641_Existing"

futureWY = 2013
historyWYs = [1935, 1970, 1988]
sequentialYRs = 2
#--------------------------------------------------------------------------------



# initialization
#################################
Param.mainScriptPath = __file__
LogUtils.initLogging()
#################################



tableName ="wytypes.table"

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

for beginWY in historyWYs:

    # dir for outTable, e.g., PA_1945_1947
    outSubDir = "PA_"+str(beginWY)+"_"+str(beginWY+sequentialYRs-1)

    # delete outSubDir content    
    FileUtils.erase(os.path.join(lookupPath, outSubDir))

    # copy all tables from inSubDir to outSubDir
    FileUtils.copyAll(os.path.join(lookupPath, inSubDir), os.path.join(lookupPath, outSubDir))

    # create lookup table for converting futureWaterYear to historicalWaterYear
    posTable = open(os.path.join(lookupPath, outSubDir,"Position_Analysis.table"),'w+'  )
    posTable.write("Position_Analysis\n")
    posTable.write("FutureWaterYear     HistoricalWaterYear\n")
    for iYear in range(sequentialYRs):
        posTable.write(str(futureWY+iYear)+"\t"+str(beginWY+iYear)+'\n')
    posTable.close()
    


    for tableName in yearlyTableList:
        outTablePath = os.path.join(lookupPath, outSubDir, tableName)
        inTablePath = os.path.join(lookupPath, inSubDir, tableName)
    
        LookupTable.copyYearlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)


    for tableName in monthlyTableList:
        
        outTablePath = os.path.join(lookupPath, outSubDir, tableName)
        inTablePath = os.path.join(lookupPath, inSubDir, tableName)
    
        LookupTable.copyMonthlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)






    
study=[]


for beginWY in historyWYs:

    endWY = beginWY + sequentialYRs - 1
    outSvarFpart = str(beginWY)+"_"+str(endWY) # e.g., 1945_1947
    studyName = 'PA_'+outSvarFpart


    DV.copyDssToFuture_waterYear(inFile, outFile, beginWY, sequentialYRs, futureWY, outSvarFpart)    
    DV.array2dss(outFile, UARM_at_2012_09, "30SEP2012 2400", "/CALLITE/UARM/STORAGE//1MON/"+ outSvarFpart +"/", "TAF")



    s = Study("studies/callite_D1641Existing_PA__2012oct/PA_template.config")
    s.setConfig(studyName, StartYear=2012, SvarFPart=outSvarFpart, LookupSubDir=studyName)
    s.writeBatch(pause=True)
    study.append(s)



