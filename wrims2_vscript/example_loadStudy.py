#=====================================================================================
# example: load a study 
#=====================================================================================
from os import path 
from scripts.wrims2.study import Study
from scripts.wrims2.runGroup import RunGroup
from scripts.tool import LogUtils, Param, LookupTable, FileUtils, DssVista
Param.mainScriptPath = path.abspath(__file__) 
Param.mainScriptDir  = path.dirname(Param.mainScriptPath)
LogUtils.initLogging()




studyRunDir = path.join(Param.mainScriptDir,'studies/callite_D1641/Run')
configFile = 'D1641.config'


s = Study('testStudy', studyRunDir)
s.importConfig(configFile)    
#s.writeBatch(pause=True)
s.run()

