from vutils import *
import scripts.tool.DssVista as DV



#-------------------------------------------------------------------------------
inFile="studies/callite_D1641_PA/DSS/CL_EXISTING_BO_081011_SV.dss"
outFile = "z:/CL_EXISTING_BO_081011_PA_SV.dss"
futureYR = 2012
historyYRs = [x for x in range(1945, 1946)]
sequentialYRs = 3   # including first year
#--------------------------------------------------------------------------------


for beginYR in historyYRs:

	DV.copyDssToFuture(inFile, outFile, beginYR, sequentialYRs, futureYR)

	
print "Done!"

exit()
