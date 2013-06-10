import sys, vutils
from vutils import *



#attr = DataSetAttr(DataType.REGULAR_TIME_SERIES,'',unit,'TIME','PER-AVER')

def arr2dss(dssfile,ds_arr,interval,starttime,path,attr):
    
    rts = RegularTimeSeries(path,starttime,interval,ds_arr,None,attr)
    writedss(dssfile,path,rts)
    return None


def copyDssToFuture(inFile, outFile, beginYR, totalYR, futureYR=-99, epart="1MON"):
    
    endYR = beginYR + totalYR - 1

    tw = timewindow("15JAN"+str(beginYR)+" 2400 - 31DEC"+str(endYR)+" 2400")  
    beginTime_new = "31JAN"+str(futureYR)+" 2400"

    g = opendss(inFile)
    g_all = findparts(g,e=epart)

    for gi in g_all:
        ref = DataReference.create(gi,tw)
        ds =  ref.getData()
        y_arr = ds.getYArray()
        interval = epart
    
        path = ref.getPathname()
        path.setPart(Pathname.F_PART,str(beginYR)+"_"+str(endYR))
        pathname_new = str(path)
        attr = ds.getAttributes()
    
        arr2dss(outFile, y_arr, interval, beginTime_new, pathname_new, attr)