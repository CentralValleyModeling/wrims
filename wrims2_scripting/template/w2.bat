REM ----------------------------------------------------------
REM set study config
pause
set MainFile=D:\CS3_Studies\calsim30_bo_version100\conv\Run\mainCONV_30.wresl
set SvarFile=D:\CS3_Studies\calsim30_bo_version100\common\DSS\CalSim30_06_SV.dss
set SvarAPart=CALSIM  
set SvarFPart=CalSim30_06
set InitFile=D:\CS3_Studies\calsim30_bo_version100\common\DSS\CalSim30_06Init.dss
set InitFPart=CalSim30_06
set DvarFile=D:\CS3_Studies\calsim30_bo_version100\conv\DSS\20120320_callite.dss
set GroundWaterDir=D:\CS3_Studies\calsim30_bo_version100\common\CVGroundwater\Data
set StartYear=1921
set StartMonth=10
set StartDay=31
set EndYear=1921
set EndMonth=10
set EndDay=31

REM ----------------------------------------------------------
REM set wrims v2 lib

set lib=D:\cvwrsm\trunk\wrims2_scripting\lib\wrims2
set ExternalDir=D:\CS3_Studies\calsim30_bo_version100\conv\Run\External
set javaPath=D:\cvwrsm\trunk\wrims2_scripting\lib\jre6\bin

set path=%lib%;%ExternalDir%

%javaPath%\java -Xmx1000m -Xss1024K -Djava.library.path=%path% -cp "%ExternalDir%;%lib%\WRIMSv2.jar;%lib%\XAOptimizer.jar;%lib%\gurobi.jar;%lib%\heclib.jar;%lib%\jnios.jar;%lib%\jpy.jar;%lib%\misc.jar;%lib%\pd.jar;%lib%\vista.jar;%lib%\commons-io-2.1.jar;%lib%\lpsolve55j.jar" wrimsv2.components.ControllerBatch %GroundWaterDir% %MainFile% %SvarFile% %InitFile% %DvarFile% %SvarFPart% %InitFPart% %SvarAPart% 1MON %StartYear% %StartMonth% %StartDay% %EndYear% %EndMonth% %EndDay% XA csv

