import sys, vutils
from vutils import *
import scripts.tool.Basic as B

bpart = "DEM_D206B_PAG"
cpart = "DEMAND-SWP-AG"
epart = "1MON"
time_window = "15JAN1992 2400 - 31DEC1992 2400"   #time window to read
new_starttime = "31JAN2014 2400"
tw = timewindow(time_window)

#-------------------------------------------------------------------------------
input_dssfile="CL_ELT_CC1_SV.dss"
output_dssfile = "test.dss"
#--------------------------------------------------------------------------------



g = opendss(input_dssfile)
g_all = findparts(g,e=epart)

for gi in g_all:
	ref = DataReference.create(gi,tw)
	path = ref.getPathname()
	pathname = str(ref.getPathname())
	y_arr = ref.getData().getYArray()
	interval = epart
	
	path.setPart(Pathname.F_PART,'1992')
	pathname_new = str(ref.getPathname())
	B.arr2dss(output_dssfile, y_arr, interval, new_starttime, pathname_new)
print "Done!"

