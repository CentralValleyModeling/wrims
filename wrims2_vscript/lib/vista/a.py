import sys, vutils
from vutils import *


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

def arr2dss(dssfile,ds_arr,interval,starttime,path,interp_type=None,unit=None):
    if unit == None:
        unit = 'CFS'
    if interp_type == None:
        attr = DataSetAttr(DataType.REGULAR_TIME_SERIES,'',unit,'TIME','INST-VAL')
    else:
        attr = DataSetAttr(DataType.REGULAR_TIME_SERIES,'',unit,'TIME',interp_type)
    rts = RegularTimeSeries(path,starttime,interval,ds_arr,None,attr)
    writedss(dssfile,path,rts)
    return None

if __name__ == '__main__':
    g = opendss(input_dssfile)
    g1 = findparts(g,b=bpart,c=cpart)
    ref = DataReference.create(g1[0],tw)
    pathname = str(ref.getPathname())
    y_arr = ref.getData().getYArray()
    interval = epart
    arr2dss(output_dssfile, y_arr, interval, new_starttime, pathname)
    print "Done!"
    sys.exit(0)
