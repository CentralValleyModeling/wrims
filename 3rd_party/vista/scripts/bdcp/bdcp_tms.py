import vutils
from vutils import *
from vdss import opendss, writedss
import javax.swing as sshwing 
from java.lang import Double
#---------------------------------------------
# define parameters for TMS Diversion Script
true = 1
false = 0
closed_on_flood = false
month_start_fish_op = 1
month_end_fish_op = 6
max_diversion = 6000
jptEcTrigger = 600
tw_string = '03OCT1974 2400 - 30SEP1991 2400'
#----------------------------------------------

def ts_extraction(input_dssfile,output_dssfile,starr,type):
    ''' time series extraction for BDCP studies '''
    time_interval = '15MIN'
    g = opendss(input_dssfile)
    for st in starr:
        try:
            g1 = findparts(g,b=st,c=type,e=time_interval)
            ref1 = g1[0]
            path = str(ref1.pathname)
            if st=='VERNALIS':   # rename VERNALIS to SJR_BOUNDARY
                path = path.replace('VERNALIS','SJR_BOUNDARY')
            writedss(output_dssfile,path,ref1.getData())
        except:
            print st + ' does not exist in the input dss file!'    


def arr2dss(dssfile,ds_arr,interval,starttime,path,interp_type=None):
    if interp_type == None:
        attr = DataSetAttr(DataType.REGULAR_TIME_SERIES,'','CFS','TIME','INST-VAL')
    else:
        attr = DataSetAttr(DataType.REGULAR_TIME_SERIES,'','CFS','TIME',interp_type)
    rts = RegularTimeSeries(path,starttime,interval,ds_arr,None,attr)
    writedss(dssfile,path,rts)
    return None

def month_ref(g,b_part,c_part):
    g1 = findparts(g,b=b_part,c=c_part)
    ref1 = g1[0]
    ref1_mon = per_avg(ref1, interval='1mon')
    return ref1_mon.getData()
    
def set_ref_path(dssfile,b_part,c_part,out_b_part,out_e_part):
    g = opendss(dssfile)
    g1 = findparts(g,b=b_part,c=c_part)
    ref1 = g1[0]
    path = ref1.getPathname()
    outpath = '/'+path.getPart(Pathname.A_PART)+'/'+out_b_part+'/'+c_part+'//'+out_e_part+'/'+path.getPart(Pathname.F_PART)+'/'
    return outpath

def sac_yolo(dssfile):
    g = opendss(dssfile)
    g1 = findparts(g,b='SAC',c='FLOW')
    g2 = findparts(g,b='YOLO',c='FLOW')
    ref1 = per_avg(g1[0],interval='1day')
    ref2 = per_avg(g2[0],interval='1day')
    ref3 = ref1 + ref2
    path = str(ref3.pathname)
    path = path.replace('SAC_PERAVG + YOLO_PERAVG','SAC_YOLO')
    writedss(dssfile,path,ref3.getData())
    return None

def sjr_boundary(dssfile):
    g = opendss(dssfile)
    g1 = findparts(g,b='SJR_BOUNDARY',c='FLOW')
    ref1 = g1[0]
    ref1_day = per_avg(ref1, interval='1day')
    path = str(ref1_day.pathname).replace('_PERAVG','')
    writedss(dssfile,path,ref1_day.getData())
    return None

def rsan018_ecmax(dssfile):
    g = opendss(dssfile)
    g1 = findparts(g,b='RSAN018',c='EC')
    ref1 = g1[0]
    ref1_day = per_max(ref1, interval='1day')
    path = str(ref1_day.pathname).replace('RSAN018PER-MAX','RSAN018')
    path = path.replace('EC','EC-MAX')
    writedss(dssfile,path,ref1_day.getData())
    return None

def txt2mon(txt):
    if txt=='JAN': m = 1
    if txt=='FEB': m = 2
    if txt=='MAR': m = 3
    if txt=='APR': m = 4
    if txt=='MAY': m = 5
    if txt=='JUN': m = 6
    if txt=='JUL': m = 7
    if txt=='AUG': m = 8
    if txt=='SEP': m = 9
    if txt=='OCT': m = 10
    if txt=='NOV': m = 11
    if txt=='DEC': m = 12
    return m

def adjust_flow_tms(dssfile):
    '''adjust flow for Threemile Slough based on the criterion:
       if (RSAC092 + CHANNEL_48_0) > 3000 cfs --> use CHANNEL_48_0
       if (RSAC092 + CHANNEL_48_0) < 3000 cfs --> use RSAN018
    '''
    g = opendss(dssfile)
    ds1_mon = month_ref(g,'RSAN018','FLOW')
    ds2_mon = month_ref(g,'RSAC092','FLOW')
    ds3_mon = month_ref(g,'CHANNEL_48_0','FLOW')
    ds4 = ds2_mon + ds3_mon  #RSAC092+CHANNEL_48_0
    ds5 = []
    switch = {}
    for i in range(len(ds4)):
        elem4 = ds4.getElementAt(i)
        if elem4.YString <> 'MISSING VALUE':
            ds5.append(float(elem4.YString))
            if float(elem4.YString) > 3000:
                ym = elem4.XString
                switch[ym[2:9]] = 1          
            else:
                ym = elem4.XString
                switch[ym[2:9]] = 0
    outpath = set_ref_path(dssfile,'RSAN018','FLOW','TMS_ADJUST_FLOW','1MON')
    arr2dss(dssfile,ds5,"1MON","31OCT1974 2400",outpath,'PER-AVER') #place the value at the end of month to obtain correct plot
    return ds5, switch

def assign_adjusted_flow(dssfile,switch):
    g = opendss(dssfile)
    g1 = findparts(g,b='CHANNEL_48_0',c='FLOW')
    g2 = findparts(g,b='RSAN018',c='FLOW')
    ref1 = g1[0]
    ref2 = g2[0]
    ds1 = ref1.getData()   #CHANNEL_48_0
    ds2 = ref2.getData()   #RSAN018
    ds3 = []
    for i in range(len(ds1)):
        elem1 = ds1.getElementAt(i)
        elem2 = ds2.getElementAt(i)
        monyr = elem1.XString[2:9]
        if elem1.YString <> 'MISSING VALUE':
            try:
                if switch[monyr] == 1:
                    ds3.append(float(elem1.YString))      
                else:
                    ds3.append(float(elem2.YString))
            except:
                print "..." + monyr + " empty."
    outpath = set_ref_path(dssfile,'RSAN018','FLOW','SJR_BLW_TMS','15MIN')
    arr2dss(output_dssfile,ds3,"15MIN","01OCT1974 0015",outpath)
    return ds3

def ts_fact(dssfile):
    g = opendss(dssfile)
    tw = timewindow(tw_string)
    g1 = findparts(g,b='SAC_YOLO',c='FLOW',e='1DAY')
    g2 = findparts(g,b='SJR_BOUNDARY',c='FLOW',e='1DAY')
    g3 = findparts(g,b='RSAN018',c='EC-MAX',e='1DAY')
    ref1 = DataReference.create(g1[0],tw)
    ref2 = DataReference.create(g2[0],tw)
    ref3 = DataReference.create(g3[0],tw)
    ds1 = ref1.getData()
    ds2 = ref2.getData()
    ds3 = ref3.getData()
    tsFact = []
    tsSacYolo = []
    tsVernalis = []
    tsJptEC = []
    x_SacYolo = []
    x_Vernalis = []
    x_JptEC = []  
    i = 0
    for j in range(len(ds1)):
        elem1 = ds1.getElementAt(j)
        x_SacYolo.append(elem1.XString)
        if elem1.YString <> 'MISSING VALUE':
            tsSacYolo.append(float(elem1.YString))
        else:
            tsSacYolo.append(-9999.)
        i += 1  
    i = 0
    for j in range(len(ds2)):
        elem2 = ds2.getElementAt(j)
        x_Vernalis.append(elem2.XString)
        if elem2.YString <> 'MISSING VALUE':
            tsVernalis.append(float(elem2.YString))
        else:
            tsVernalis.append(-9999.)
        i += 1
    i = 0
    for j in range(len(ds3)):
        elem3 = ds3.getElementAt(j)
        x_JptEC.append(elem3.XString)
        if elem3.YString <> 'MISSING VALUE':
            tsJptEC.append(float(elem3.YString))
        else:
            tsJptEC.append(-9999.)
        i += 1
    for i in range(len(tsSacYolo)):
        #print i, x_SacYolo[i],x_Vernalis[i],x_JptEC[i],tsSacYolo[i],tsVernalis[i],tsJptEC[i]
        if tsSacYolo[i] <> -9999.:
            strTime = x_SacYolo[i]
            imon = txt2mon(strTime[2:5])
            if imon >= month_start_fish_op and imon < month_end_fish_op:
                tsFact_tmp = 1.0
                if ( closed_on_flood ):
                    tsFact_tmp = -9999.0
                # Sac+Yolo and SJR flow limits - closed on flood
                    if ( tsSacYolo[i] > 30000 or tsVernalis[i] > 10000 ):
                        tsFact_tmp = 0.0
                else:
                # Sac+Yolo and SJR flow limits - closed on ebb 
                    if ( tsSacYolo[i] > 35000 or tsVernalis[i] > 12000 ):
                        tsFact_tmp = 0.0
        # wq operation
            else:
                if ( tsJptEC[i] > jptEcTrigger ):
                    tsFact_tmp = 1.0
                else:
                    tsFact_tmp = 0.0
                if ( tsSacYolo[i] > 80000 or tsVernalis[i] > 35000 ):
                    tsFact_tmp = 0.0
        else:
            tsFact_tmp = 0    
        tsFact.append(tsFact_tmp)          
    path = g1[0].getPathname()
    if (closed_on_flood):
        outpath = '/'+path.getPart(Pathname.A_PART)+'/TMS FACTOR EHSU/FACTOR//1DAY/FISH Closed on flood/'    
    else:
        outpath = '/'+path.getPart(Pathname.A_PART)+'/TMS FACTOR EHSU/FACTOR//1DAY/FISH FLOW BALANCE/'    
    arr2dss(dssfile,tsFact,"1DAY",tw_string[0:14],outpath,'PER-AVER')
    return tsFact

def tms_diversion(dssfile,tsFact):
    div_factstr = sshwing.JOptionPane.showInputDialog("Enter SRJ flow split fraction : ")
    div_fact = Double.parseDouble(div_factstr)
    minRsac092 = 0
    tw = timewindow(tw_string)
    tsTmsDiv = []
    if ( div_fact < .0 or div_fact > 1. ):
        MessageBox.showError( "Flow split factor should be >= 0 and <= 1", "Error")
        return false
    g = opendss(dssfile)
    g1 = findparts(g,b='RSAC092',c='FLOW',e='15MIN')
    g2 = findparts(g,b='SJR_BLW_TMS',c='FLOW',e='15MIN')
    ref1 = DataReference.create(g1[0],tw)
    ref2 = DataReference.create(g2[0],tw)  
    ref1 = godin(ref1)
    ref2 = godin(ref2)
    ref1 = per_avg(ref1,'1day')
    ref2 = per_avg(ref2,'1day')
    path = ref1.getPathname()
    path1 = '/'+path.getPart(Pathname.A_PART)+'/RSAC092/FLOW-GODIN//1DAY/'+path.getPart(Pathname.F_PART)+'/'    
    path2 = '/'+path.getPart(Pathname.A_PART)+'/SJR_BLW_TMS/FLOW-GODIN//1DAY/'+path.getPart(Pathname.F_PART)+'/'    
    writedss(dssfile,path1,ref1.getData())
    writedss(dssfile,path2,ref2.getData())
    tmRsac092, tsRsac092Daily = ts2arr(ref1.getData())
    tmSjrBlwTMS, tsSjrBlwTMSDaily = ts2arr(ref2.getData()) 
    for i in range(len(tsRsac092Daily)):
        flow_diff = tsRsac092Daily[i] - tsSjrBlwTMSDaily[i]
        tmp_div = div_fact * flow_diff
        if tmp_div > max_diversion:
            tmp_div = max_diversion
        new_RsacEmm = tsRsac092Daily[i] - tmp_div
        if new_RsacEmm < minRsac092:
            tmp_div -= minRsac092 - new_RsacEmm 
        if tmp_div < 0:
            tmp_div = 0.
        tsTmsDiv.append(tmp_div * tsFact[i])
    outpath = '/'+path.getPart(Pathname.A_PART)+'/TMS DIVERSIONS NEW HSU/FLOW//1DAY/SJR FRAC' + div_factstr + '/'    
    arr2dss(dssfile,tsTmsDiv,"1DAY",tw_string[0:14],outpath,'PER-AVER')
    return tsTmsDiv

def ts2arr(ts):
    outarrx = []
    outarry = []
    for j in range(len(ts)):
        elem = ts.getElementAt(j)
        outarrx.append(elem.XString)
        if elem.YString <> 'MISSING VALUE':
            outarry.append(float(elem.YString))
        else:
            outarry.append(-9999.)    
    return outarrx,outarry

if __name__ == '__main__':
    input_dssfile = 'D:/delta/dsm2_v8/studies/Delta_Corridor_NT/output/Delta_Corridor_NT_BO_out.dss'
    output_dssfile = 'D:/delta/dsm2_v8/studies/Delta_Corridor_NT/output/DC_NT_Extract.dss'

    print "Time Series Extraction...."
    flow = ['CHANNEL_48_0','RSAC092','RSAN018','SAC','SLTRM004','VERNALIS','YOLO']
    ec = ['RSAN018']
    ts_extraction(input_dssfile,output_dssfile,flow,'FLOW')
    ts_extraction(input_dssfile,output_dssfile,ec,'EC')
    
    print "Create Sac+Yolo daily flow time series..."
    sac_yolo(output_dssfile)
    
    print "Create SJR_Boundary daily flow time series..."
    sjr_boundary(output_dssfile)
    
    print "Create RSAN018 daily EC-MAX time series..."
    rsan018_ecmax(output_dssfile)    
    
    print "Adjusting flows for Threemile Slough Gate Operation...."
    ds,switch = adjust_flow_tms(output_dssfile)
    ds_15min = assign_adjusted_flow(output_dssfile,switch)
    
    print "Produce daily time series for TMS Factor..."
    ts_fact = ts_fact(output_dssfile)
    
    print "Produce daily time series for TMS Diversion..."
    tms_diversion(output_dssfile,ts_fact)
    
    print "Done!"
    
    sys.exit(0)