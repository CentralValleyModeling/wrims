# timestep must be monthly 
# NumberOfSteps ( or "periods" in wrims1 multi-study runner ) must be a multiple of 12
import os
from scripts.classes.study import Study
from scripts.misc import LogUtils, Param
#import shutil

LogUtils.initLogging(__file__)


dir = os.path.dirname(os.path.realpath(__file__))


# default batch file to call is 'RunStudy.bat'
s1_configPath = os.path.join(dir, r"studies\callite_D1641\D1641.config")

print s1_configPath

s1=Study(s1_configPath)
s1.run(startYear=1921, numberOfSteps=12)