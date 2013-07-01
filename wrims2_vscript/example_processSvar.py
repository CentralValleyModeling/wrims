import os
from vutils import *
import scripts.tool.DssVista as DV


#-------------------------------------------------------------------------------
inFile="studies/callite_D1641Existing_PA__2012oct/Run/DSS/CL_EXISTING_BO_081011_SV.dss"
outFile = "z:/CL_EXISTING_BO_081011_PA_SV.dss"
futureWY = 2013
historyWYs = [x for x in range(1945, 1946)]
sequentialYRs = 3   # including first year
#--------------------------------------------------------------------------------


for beginWY in historyWYs:


	DV.copyDssToFuture_waterYear(inFile, outFile, beginWY, sequentialYRs, futureWY)

	
print "Done!"

exit()
