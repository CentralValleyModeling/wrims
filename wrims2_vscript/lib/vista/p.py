import sys, vutils
from vutils import *

bpart = "CH_78_0"
cpart = "FLOW"
epart = "1DAY"
time_window = "15APR1992 2400 - 02JUN1992 2400"   #time window to read
new_starttime = "03APR2004 2400"
tw = timewindow(time_window)

#-------------------------------------------------------------------------------
input_dssfile="Tidal_PostPro_No_CVP_Barriers.dss"
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
