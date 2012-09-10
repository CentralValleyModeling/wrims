#!/bin/bash

# declare EXTERNALFOLDER variable
EXTERNALFOLDER="/scratch/00359/hxie/callite_v47/callite/run/external"
MAINFILE="/scratch/00359/hxie/callite_v47/callite/run/main_bo.wresl"
SVFILE="/scratch/00359/hxie/hxie/callite_v47/callite/dss/cl_future_bo_011012_sv.dss"
INITFILE="/scratch/00359/hxie/hxie/callite_v47/callite/dss/callite2020d09einit.dss"
DVFILE="/scratch/00359/hxie/hxie/callite_v47/callite/dss/testdv.dss"

PATH=/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit:$PATH
PATH=$EXTERNALFOLDER:$PATH
export PATH 

LD_LIBRARY_PATH=$EXTERNALFOLDER:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit:$LD_LIBRARY_PATH
export LD_LIBRARY_PATH

/scratch/00359/hxie/wrimsv2_SG_64bit/jre6/bin/java -Xmx1600m -Xss1024K -Duser.timezone=UTC -Djava.library.path=$EXTERNALFOLDER:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit -cp "$EXTERNALFOLDER:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/external:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/WRIMSv2.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/XAOptimizer.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/lpsolve55j.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/gurobi.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/heclib.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/jnios.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/jpy.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/misc.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/pd.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/commons-io-2.1.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/javatuples-1.2.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/guava-11.0.2.jar:/scratch/00359/hxie/wrimsv2_SG_64bit/bin/../lib64bit/vista.jar" wrimsv2.components.ControllerBatch -config="/scratch/00359/hxie/callite_v47/callite/run/callite_lpsolve.config"

exit
