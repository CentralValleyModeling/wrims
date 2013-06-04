# timestep must be monthly 
# NumberOfSteps ( or "periods" in wrims1 multi-study runner ) must be a multiple of 12

from scripts.classes.study import Study
from scripts.misc import LogUtils, Param
#import shutil

LogUtils.initLogging(__file__)


# default batch file to call is 'RunStudy.bat'
s1=Study(r"D:\cvwrsm\trunk\WRIMS2_Vscript\studies\callite_D1641\D1641.config")
s1.run(startYear=1921, numberOfSteps=12)