from vutils import *
import scripts.tool.Basic as B



#-------------------------------------------------------------------------------
inFile="CL_ELT_CC1_SV.dss"
outFile = "z:/shifted.dss"
totalYR = 3
#--------------------------------------------------------------------------------


for beginYR in range(1945,1967):

	B.copyDssToFuture(inFile, outFile, beginYR, totalYR, futureYR=2014)

	
print "Done!"

exit()