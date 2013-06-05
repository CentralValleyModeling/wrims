#=====================================================================================
#  TimeStep must be monthly 
#  NumberOfSteps must be a multiple of 12
#=====================================================================================

import os
from scripts.classes.study import Study
from scripts.misc import LogUtils, Param
#import shutil

LogUtils.initLogging(__file__)
d = os.path.dirname(os.path.realpath(__file__))


# default batch file to call is 'RunStudy.bat'
s1=Study(d, r"studies\callite_D1641\D1641.config")
#s1.run(startYear=1921, numberOfSteps=12)
s1.run()