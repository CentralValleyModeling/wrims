#=====================================================================================
# example: read txt into dss
#=====================================================================================

import vutils as vu
from scripts.tool import DssVista

text_file = open("./data.txt", "r")
dss_file ="./txt2DSS.dss"

lines = text_file.readlines()

pathname  = lines[0].strip()
begin_time = lines[1].strip()
interval  = lines[2].strip()
units = lines[3].strip()

print pathname, begin_time, interval, units

#beginTime = "31OCT2012 2400"
interval = "1MON"
pathname = "/CALLITE/X/FLOW///SCENARIO_101/"

array = map(float, lines[4:])

print array

attr = vu.DataSetAttr(vu.DataType.REGULAR_TIME_SERIES, "TIME", "CFS", "", "PER-AVER");
      
DssVista.arr2dss(dss_file, array, interval, begin_time, pathname, attr)

print 'completed.'





    
    

    
    