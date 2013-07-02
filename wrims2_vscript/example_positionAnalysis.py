#=====================================================================================
#  TimeStep must be monthly 
#=====================================================================================

from scripts.wrims2.study import Study
from scripts.tool import LogUtils, Param
import scripts.tool.DssVista as DV
import copy

# User Input
#-------------------------------------------------------------------------------
inFile="studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_SV.dss"
outFile = "studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_PA_SV.dss"
futureWY = 2013
historyWYs = [x for x in range(1945, 1948)]
sequentialYRs = 2   # including first year

# UARM: Upper American River Model, that is storage in French Meadows, 
# Hell Hole, and Union Valley Reservoirs, which are upstream of Folsom.
# Tom Fitzhugh 

UARM_at_2012_09 = [300] 
#--------------------------------------------------------------------------------


# initialization
#################################
Param.mainScriptPath = __file__
LogUtils.initLogging()
#################################



    
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



