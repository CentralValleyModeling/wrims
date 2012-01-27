import scripts.PA_Utils as PA
import os

#=======================================================

beginFutureYR = 2011
beginPastYR = 1923
endPastYR = 1924 #1997
numberOfSequentialYRs = 5

dssBufferYRs = 2
tableBufferYRs = 2  

#studyDir      = r"{app}\studies\BST_2005A01A_Existing\CALSIM_040110_PA"
studyDir      = r"D:\cvwrsm\trunk\pa\CalSimPA\studies\BST_2005A01A_Existing\CALSIM_040110_PA"


runDir        = os.path.join( studyDir, "CONV\Run")
inputDssDir   = os.path.join( studyDir, "common\DSS")
outputDssDir  = os.path.join( studyDir, "CONV\DSS")

exeName = "mainCONV.exe"
styTemplate = "study.template"

originalSvDssFile = os.path.join( inputDssDir, "2005A01ASV.dss")
shiftedSvDssFile  = os.path.join( inputDssDir, "Shifted2SV.dss")
initialDssFile    = os.path.join( inputDssDir, "2005A01A_Run2011_INIT.DSS" )
resultDssFile     = os.path.join( outputDssDir, "PA_DV.DSS" ) 
lookupDir         = os.path.join( runDir,       "Lookup")

showWindow = "TRUE"

#=======================================================

yearlyTableTemplateList  = [ "wytypes.template",
                             "wytypeSJR.template",
                             "LCPSIM_SB_Output.template",
                             "lcpsim_sc_output.template", 
                             "lcpsim_nb_output.template",
                             "wytypeSJR_Rest.template",
                             "WTS_Stage1_Targets.template",
                             "wytypeSJRave5.template",
                             "AnnualReqDel_swp.template",
                             "FebEiRatio.template",
                             "SacValleyIndex.template",
                             "CAM_Oro_Apr_Jul.template",
                             "Kern_GW_RechLim.template",
                             "eightriver.template",
                             "FWS_BO_A3_Temp.template",
                             "sacramento_runoff_forecast.template",
                             "american_runoff_forecast.template",
                             "ouwua_ann_dem.template",
                             "delta_index.template",
                             "apr_sep_inflow_nat.template",
                             "CAM_SVI.template"                            
                            ]

monthlyTableTemplateList  = [ "frst_Oro_Apr_Jul.template",
                             "feather_runoff_forecast.template",
                             "x2days.template" ]

monthlyTableMonthList    = [ [4,5,6,7,8,9],
                              [4,5,6,7,8],
                              [5,6,7,8,9]
                           ]  

#=======================================================

PA.setConfig(runDir, lookupDir, originalSvDssFile, shiftedSvDssFile, 
             styTemplate, exeName,
             yearlyTableTemplateList, monthlyTableTemplateList, monthlyTableMonthList,
             initialDssFile, resultDssFile, showWindow
             )

PA.setTime(beginPastYR, endPastYR, numberOfSequentialYRs, beginFutureYR, dssBufferYRs, tableBufferYRs)

PA.cleanDss()
PA.processDss()

PA.cleanTables()
PA.processYearlyTables()
PA.processMonthlyTables()

PA.cleanSty()
PA.processSty()

PA.processRunBatch('wrims1')













