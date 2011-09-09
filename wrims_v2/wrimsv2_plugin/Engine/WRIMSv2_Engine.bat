@echo off

set Java_Bin=D:\cvwrsm\trunk\3rd_party\jrockit-jre1.6.0_26-R28.1.4\bin\
set path=D:\cvwrsm\trunk\calsim30\calsim30_bo\conv\Run\External;D:\cvwrsm\trunk\3rd_party\vista\lib;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib;%path%

D:\cvwrsm\trunk\3rd_party\jrockit-jre1.6.0_26-R28.1.4\bin\java -Xmx1600m -Xss1024K -Djava.library.path="D:\cvwrsm\trunk\calsim30\calsim30_bo\conv\Run\External;D:\cvwrsm\trunk\3rd_party\vista\lib;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib" -cp "D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\lpsolve55j.jar;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\WRIMSv2.jar;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\wrimsv2\external\*.class;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\XAOptimizer.jar;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\gurobi.jar;D:\cvwrsm\trunk\wrims_v2\wrimsv2_plugin\Engine\lib\ilpObj.jar;D:\cvwrsm\trunk\3rd_party\vista\lib\*" wrimsv2.components.Controller D:\cvwrsm\trunk\calsim30\calsim30_bo\common\CVGroundwater\Data\ D:\cvwrsm\trunk\calsim30\calsim30_bo\conv\Run\mainCONV_30.wresl D:\cvwrsm\trunk\calsim30\calsim30_bo\common\DSS\CalSim30_06_SV.dss D:\cvwrsm\trunk\calsim30\calsim30_bo\common\DSS\CalSim30_06Init.dss D:\cvwrsm\trunk\calsim30\calsim30_bo\conv\DSS\TestWRIMSV2DV.dss CalSim30_06 CalSim30_06 CALSIM 1MON 1921 10 31 2003 10 31 XA csv



