from vutils import *
import scripts.tool.Basic as B



#-------------------------------------------------------------------------------
inFile="CL_ELT_CC1_SV.dss"
outFile = "z:/shifted.dss"
futureYR = 2014
historyYRs = [x for x in range(1945, 1967)]
sequentialYRs = 3
#--------------------------------------------------------------------------------


for beginYR in historyYRs:

	B.copyDssToFuture(inFile, outFile, beginYR, sequentialYRs, futureYR)

	
print "Done!"

exit()