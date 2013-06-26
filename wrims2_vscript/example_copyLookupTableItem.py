import os
from scripts.tool import LookupTable
from scripts.tool import Misc


#-------------------------------------------------------------------------------
lookupPath = "studies/callite_D1641Existing_PA__2012oct/Run/Lookup"
inSubDir = "PA_Base_D1641_Existing"

futureYR = 2012
historyYRs = [x for x in range(1945, 1947)]
sequentialYRs = 3
#--------------------------------------------------------------------------------

tableName ="wytypes.table"

yearlyTableList = ["wytypes.table",
				   "wytypesjr.table",
				   "wytypeD1485.table",
				   "wytypeDefic.table",
				   "wytypeSnow.table",
				]


for beginYR in historyYRs:

	# dir for outTable, e.g., PA_1945_1947
	outSubDir = "PA_"+str(beginYR)+"_"+str(beginYR+sequentialYRs-1)

	# delete outSubDir content	
	Misc.erase(os.path.join(lookupPath, outSubDir))

	# copy all tables from inSubDir to outSubDir
	Misc.copyAll(os.path.join(lookupPath, inSubDir), os.path.join(lookupPath, outSubDir))


	for tableName in yearlyTableList:
		outTablePath = os.path.join(lookupPath, outSubDir, tableName)
		inTablePath = os.path.join(lookupPath, inSubDir, tableName)
	
		LookupTable.copyYearlyWYTypesToFuture(inTablePath, outTablePath, beginYR, sequentialYRs, futureYR)

	
print "Done!"

exit()
