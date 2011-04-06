from vtidefile import opentidefile
from vdss import writedss
import sys
def get_volumes_data(tidefile,channel_ranges):
    tf=opentidefile(tidefile)
    volumes=[]
    for chan_range in channel_ranges:
        lo,hi=chan_range
        print lo,hi
        for chan in range(int(lo),int(hi+1)):
            refs=tf.find(['','^%s$'%chan,'VOLUME'])
            if refs and len(refs)==1:
                volumes.append(refs[0].data)
    return volumes
def total(volumes):
    tv=None
    for v in volumes:
        if not tv:
            print 'First tv = ',v.name
            tv=v
        else:
            print 'Adding tv to ',v.name
            tv=tv+v
    return tv
#
if __name__=='__main__':
    if (len(sys.argv) < 2):
        print """An input configuration file needs to specified: Below is an example
>>>>>> Configuration File START >>>>>>>>>>>>>>>>>
# A configuration input file for calculating volume from a tidefile and channel ids specified
[default]
# Input tidefile to use
tidefile=c:/temp/tidefile.h5
# Channel ranges define the channels that make up the control volume
channel_ranges=[(54,82),(84,105),(183,203),(125,145),(204,214),(216,231),(233,235),(252,259)]
# output dss file and path
output_dss_file=c:/temp/output.dss
output_dss_path=/CALC/SOUTH-DELTA/VOLUME//60MIN/CALC/
<<<<<< Configuration File END <<<<<<<<<<<<<<<<<<<<
        """
        exit(1)
    config_file=sys.argv[1]
    from ConfigParser import ConfigParser
    config=ConfigParser()
    config.read(config_file)
    tidefile=config.get('default','tidefile')
    cranges_raw=config.get('default','channel_ranges')
    print 'Calculating volume from tidefile: %s'%tidefile
    print 'Channel ranges: %s'+cranges_raw
    #channel_ranges=[(54,105),(183,203),(125,145),(204,225),(217,231),(233,235),(252,257)]
    #channel_ranges=[(54,82),(84,105),(183,203),(125,145),(204,214),(216,231),(233,235),(252,259)]
    channel_ranges=eval(cranges_raw)
    volumes=get_volumes_data(tidefile, channel_ranges)
    total_volume=total(volumes)
    outdssfile=config.get('default','output_dss_file')
    outdsspath=config.get('default','output_dss_path')
    print 'Writing out to %s as %s'%(outdssfile,outdsspath)
    writedss(outdssfile,outdsspath,total_volume)
    exit(0)
# 