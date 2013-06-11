from vutils import *
import scripts.tool.DssVista as DV



#-------------------------------------------------------------------------------
inFile="CL_ELT_CC1_SV.dss"
outFile = "z:/shifted.dss"
futureYR = 2014
historyYRs = [x for x in range(1945, 1946)]
sequentialYRs = 3
#--------------------------------------------------------------------------------


for beginYR in historyYRs:

	DV.copyDssToFuture(inFile, outFile, beginYR, sequentialYRs, futureYR)

	
print "Done!"

exit()