# timestep must be monthly 
# NumberOfSteps ( or "periods" in wrims1 multi-study runner ) must be a multiple of 12

from scripts.classes.study import Study
from scripts.misc import LogUtils

LogUtils.initLogging(__file__)


s1=Study(r"D:\cvwrsm\trunk\wrims2_scripting\studies\callite_svn47\CONV\Run\CONV.config")
s2=Study(r"D:\cvwrsm\trunk\wrims2_scripting\studies\callite_svn47\TXFR\Run\TXFR.config")

# copy all dvars in s1.DvarFile to destination
# id must be unique
s1.add_dss_transfer(id="copy_all_1", destn=s1.InitFile, destn_Fpart=s1.InitFPart)
s1.add_dss_transfer(id="copy_all_2", destn=s1.InitFile, destn_Fpart=s1.InitFPart)

# copy variables specified in "to_common_init.transfer" from s1.DvarFile to destination
s1.add_dss_transfer(id="to_init", destn=s1.InitFile, destn_Fpart=s1.InitFPart, transferFile="to_common_init")

# copy variables specified in "to_common_svar" from s1.DvarFile to destination
s1.add_dss_transfer(id="to_svar", destn=s1.SvarFile, destn_Fpart=s1.SvarFPart, transferFile="to_common_svar")


for year in range(1921, 1925):
	
	
	s1.run(startYear=year, numberOfSteps=12)



	
