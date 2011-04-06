__doc__ ="""

"""
"""
A collection of utilities for vista
This module contains the functions for checking data based on its value, rate of
change, quality flag values etcetra.
"""
import sys, datetime
from vista.set import TimeSeriesMath
from vtimeseries import *
from java.lang import System

TimeSeriesMath.DUMB_PATCH = 0 # disable dumb patches per Eli's recommendation
# check for jnios
vh = System.getProperty("vista.home")
try:
    if not vh:
	System.loadLibrary("errno")
	System.loadLibrary("posix")
    else:
	osname = System.getProperty("os.name")
	fs = System.getProperty("file.separator")
	if string.find(osname,"Sun") != -1:
	    System.load(vh+fs+"lib"+fs+"liberrno.so")
	    System.load(vh+fs+"lib"+fs+"libposix.so")
	elif string.find(osname,"Win") != -1:
	    System.load(vh+fs+"lib"+fs+"errno.dll")
	    System.load(vh+fs+"lib"+fs+"posix.dll")
	else:
	    System.loadLibrary("errno")
	    System.loadLibrary("posix")
except:
    pass
# check for display
from java.awt import Toolkit
display = 1
try :
    tk = Toolkit.getDefaultToolkit()
except:
    print 'Problem with display'
    display = 0
#
from vista.db.dss import DSSUtil
from vista.app import MainProperties
DSSUtil.setAccessProperties(MainProperties.getProperties())
#
from vdss import *
from vtimeseries import *
from vdisplay import *

#
def exit():
    sys.exit()
#
def flag_data(ftype, dataset, valArray, log = 'flag.log',Special = False):
    """
    flag_data(ftype, dataset, valArray, log = 'flag.log', Special = False):
    Flags a datastream's values for bad data:
    ftype='R': datavalue not within valArray[0]:valArray[1] marked as reject.
         ='D': datavalue difference from previous value not within
               valArray[0] range marked as reject. If len(valArray) > 1, 
               valArray[0] is a percentage, not an absolute value
         ='M': datavalue equals or very close to val[0:], an array of Missing Value markers;
               DSS flag set to missing. Optional Special means marker value
               is within normal data range, check more carefully.
         ='+|*': datavalue within range valArray[0]:valArray[1] scaled by valArray[2]
               amount, that is, datavalue is added/multiplied to/by valArray[2]. Used mainly
               for CDEC EC data that switches between milli- and micro-mhos/cm and
               to add 100 to USGS stage data.
    All values marked are written to log file.
    Flags added to timeseries if needed.
    """
    def nearVal (val, target, tol=.001):
        # return True if abs(val-target) < tol
        if abs(val-target) < tol:
            return True
        else:
            return False
    if ftype == 'R':
        if len(valArray) != 2: 
            # assume hi and lo range will be calculated from percentiles
            yVals = sorted(SetUtils.createYArray(dataset))
            # lo and hi: 1st and 99th percentiles
            valArray = [yVals[int(len(yVals)*0.01)], yVals[int(len(yVals)*0.99)]]
        rej_head = 'Check range ' + str(valArray[0]) + ' - ' + str(valArray[1])
        rej_note = 'Range reject @ '
    elif ftype == 'D':
        diffPct = False
        rej_head = 'Check diff w/ prev value ' + str(valArray[0])
        rej_note = 'Diff reject @ '
        if len(valArray) > 1: # percentage
            diffPct = True
            rej_head = 'Check diff w/ prev value ' + str(valArray[0]) + ' percent'
            valArray[0] /= 100.
            yVals = sorted(SetUtils.createYArray(dataset))
            # difference between 10th and 90th percentiles
            pdiff = abs(yVals[int(len(yVals)*0.10)] - yVals[int(len(yVals)*0.90)])
            rej_note = 'Diff reject % @ '
    elif ftype == 'M':
        if len(valArray) < 1: raise 'At least one value must be given for Missing check.'
        rej_head = 'Check Missing value marker ' + str(valArray)
        rej_note = 'Missing @ '
    elif ftype == '+' or ftype == '*':
        if len(valArray) != 3: raise 'Three values must be given for Shift.'
        rej_head = 'Check scale ' + str(valArray[0]) + ' - ' + str(valArray[1])
        rej_note = 'Value scaled @ '
    else: raise 'First arg must be a single character R, D or M.'
    # nominal time interval in minutes to detect gaps in data
    intvls = {'IR-DAY': 15, 'IR-MON': 60, 'IR-YEAR': 1440, \
             '15MIN': 15, '1HOUR': 60, '1DAY': 1440}
    ePart = dataset.getName().split('/')[5]
    nomIntvl = intvls[ePart]
    # a flag to check if any flag was changed
    changedFlag = False
    # get the filter for missing values
    filter = Constants.DEFAULT_FLAG_FILTER
    # check if ds already has flags, if not, make them
    # open log file
    logfile = open(log, 'a')
    logfile.write('\n\n' + 'Name: ' + dataset.getName())
    logfile.write('\n' + 'Units: ' + dataset.getAttributes().getYUnits())
    logfile.write('\n' + rej_head)
    if dataset.isFlagged(): ds = dataset
    else: ds = ds_add_flags(dataset)
    # get user id for setting flags
    uId = DSSUtil.getUserId('datachecker')
    # create a missing data element
    ex = dataset.getElementAt(0)
    ex.setY(Constants.MISSING_VALUE)
    ex.setFlag(FlagUtils.MISSING_FLAG)
    eBad = None
    intvl = None
    for i in range(dataset.size()):
        changedEl = False
        e1 = dataset.getElementAt(i)
        # get the data elements at the i, i-1, and i+1 positions
        if i > 0:
            e0 = dataset.getElementAt(i - 1)
            intvl = int(e1.getX() - e0.getX() + .01)
        else: e0 = ex
        if i < len(dataset) - 1: e2 = dataset.getElementAt(i + 1)
        else: e2 = ex
        if ftype == 'R':    # Range
            if not filter.isAcceptable(e1): continue
            if e1.y < valArray[0] or e1.y > valArray[1] :
                FlagUtils.setQualityFlag(e1, FlagUtils.REJECT_FLAG, uId)
                changedEl = True
        elif ftype == 'D':  # Difference (abs or %) between values
            diff1 = 0
            # skip check if data time gap noted
            if intvl > nomIntvl:
                continue
            if filter.isAcceptable(e1) and \
               filter.isAcceptable(e0): diff1 = abs(e0.y - e1.y)
            if diffPct: diff1 /= pdiff
            # check for spikes and longer plateaus near a bad value
            if diff1 > valArray[0] or \
                (eBad and nearVal(e1.y, eBad.y, abs(eBad.y*.001))):
                FlagUtils.setQualityFlag(e1, FlagUtils.REJECT_FLAG, uId)
                changedEl = True
                if not eBad:
                    eBad = e1
            else:
                eBad = None
        elif ftype == 'M':  # Missing values
            for vA in valArray:
                if nearVal(vA, e1.y):
                    if not Special or (Special and \
                    # Special treatment for Missing values that are within the
                    # normal operating range of the parameter; check that the value
                    # before or after is also Missing or not acceptable before
                    # marking this value as Missing
                     (not filter.isAcceptable(e0) or not filter.isAcceptable(e2)) or \
                     (nearVal(vA, e0.y) or nearVal(vA, e2.y))):
                        FlagUtils.setQualityFlag(e1, FlagUtils.MISSING_FLAG, uId)
                        #e1.y=Constants.MISSING_VALUE
                        changedEl = True
        elif ftype == '+':  # re-scale
            if not filter.isAcceptable(e1): continue
            if e1.y >= valArray[0] and e1.y <= valArray[1] :
                e1.y += valArray[2]
                changedEl = True
        elif ftype == '*':  # re-scale
            if not filter.isAcceptable(e1): continue
            if e1.y >= valArray[0] and e1.y <= valArray[1] :
                e1.y *= valArray[2]
                changedEl = True
        if changedEl:
            changedFlag = True
            dataset.putElementAt(i, e1) # put the element back into the data set
            logfile.write('\n' + rej_note + e1.getXString() + " : " + e1.getYString())
    # end the for loop
    logfile.close()
    if changedFlag:
        return ds
    else:
        return None

    
def display_missing(ds):
    """
    display_missing(ds)
    where
    ds is a data set or time series
    displays missing value ranges for given time series
    """
    dsi = ds.getIterator()
    while not dsi.atEnd():
        el = dsi.getElement()
        begin_date = None
        while not Constants.DEFAULT_FLAG_FILTER.isAcceptable(el):
            if begin_date == None: begin_date = el.getXString()
            end_date = el.getXString()
            dsi.advance()
            if dsi.atEnd():
                break
            el = dsi.getElement()
            #print el
        if begin_date != None:
            print 'Missing for %s to %s'%(begin_date,end_date)
        if dsi.atEnd(): break
    dsi.advance()
#
def diff(rts1, rts2, outfile=None):
    '''
    diff(rts1,rts2,outfile=None):
    Prints to stdout the differences between rts1 and rts2 to
    outfile or if outfile is None to standard out. When writing
    to file it appends to existing outfile if any.
    '''
    if outfile == None:
        fh = sys.stdout
    else:
        fh = open(outfile, 'a+')
    if rts1.getTimeInterval().compare(rts2.getTimeInterval()) != 0:
        raise "Incompatible time intervals for %s and %s" % (rts1.getName(), rts2.getName())
    tw = rts1.getTimeWindow()
    if not tw.isSameAs(rts2.getTimeWindow()):
        fh.write('TimeWindow for %s is %s & %s is %s\n'\
             % (rts1.getName(), str(rts1.getTimeWindow()), \
               rts2.getName(), str(rts2.getTimeWindow())))
    tw = tw.intersection(rts2.getTimeWindow())
    if tw == None:
        raise "No intersecting time window for %s and %s" % (rts1.getName(), rts2.getName())
    else:
        rts1 = rts1.createSlice(tw)
        rts2 = rts2.createSlice(tw)
        dsi1 = rts1.getIterator()
        dsi2 = rts2.getIterator()
        while not dsi1.atEnd():
            e1 = dsi1.getElement()
            e2 = dsi2.getElement()
            if e1.y != e2.y:
                fh.write('Value difference @ %s , 1: %f , 2: %f\n'\
                     % (e1.getXString(), e1.y, e2.y))
            if e1.flag != e2.flag:
                fh.write('Flag difference @ %s , 1: %s, 2: %s\n'\
                     % (e1.getXString(), e1.getFlagString(), e2.getFlagString()))
            dsi1.advance()
            dsi2.advance()
#

