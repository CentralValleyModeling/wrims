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



s = Study('testStudy', 'studies/callite_D1641')
s.loadConfig('studies/callite_D1641/D1641.config')    
s.writeBatch(pause=True)

