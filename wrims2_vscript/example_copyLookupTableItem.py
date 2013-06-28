import os
from scripts.tool import LookupTable
from scripts.tool import Misc


#-------------------------------------------------------------------------------
lookupPath = "studies/callite_D1641Existing_PA__2012oct/Run/Lookup"
inSubDir = "PA_Base_D1641_Existing"

futureWY = 2013
historyWYs = [x for x in range(1945, 1946)]
sequentialYRs = 3
#--------------------------------------------------------------------------------

tableName ="wytypes.table"

yearlyTableList = ["wytypes.table",
				   "wytypesjr.table",
				   "wytypeD1485.table",
				   "wytypeDefic.table",
				   "wytypeSnow.table",
				   "AnnualReqDel_swp.table",
				   "SacValleyIndex.table",
				   "eightriver.table",
				   "FWS_BO_A3_Temp.table",
				   "wheelCap.table",
				   "sacramento_runoff_forecast.table",
				   "american_runoff_forecast.table",
				   "febeiratio.table",
				   "delta_index.table",
				]

monthlyTableList = ["feather_runoff_forecast.table",
				    "x2days.table",
				]

for beginWY in historyWYs:

	# dir for outTable, e.g., PA_1945_1947
	outSubDir = "PA_"+str(beginWY)+"_"+str(beginWY+sequentialYRs-1)

	# delete outSubDir content	
	Misc.erase(os.path.join(lookupPath, outSubDir))

	# copy all tables from inSubDir to outSubDir
	Misc.copyAll(os.path.join(lookupPath, inSubDir), os.path.join(lookupPath, outSubDir))


	for tableName in yearlyTableList:
		outTablePath = os.path.join(lookupPath, outSubDir, tableName)
		inTablePath = os.path.join(lookupPath, inSubDir, tableName)
	
		LookupTable.copyYearlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)


	for tableName in monthlyTableList:
		
		outTablePath = os.path.join(lookupPath, outSubDir, tableName)
		inTablePath = os.path.join(lookupPath, inSubDir, tableName)
	
		LookupTable.copyMonthlyTableToFuture(inTablePath, outTablePath, beginWY, sequentialYRs, futureWY)
			
print "Done!"

exit()
