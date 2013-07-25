@echo off
rem ##############################
rem Batch file for running vscript
rem ##############################

set lib_home=%~dp0/lib/
set vista_home=%lib_home%/vista/
set hec_home=%lib_home%/hecdss/
set wrims2_home=%lib_home%/wrims2/
set misc_home=%lib_home%/misc/
set jre_home=%~dp0/jre6/

setlocal
rem ###############
rem Set path to location of dll
rem ###############

set PATH=%path%;%vista_home%/bin;%vista_home%/lib;%wrims2_home%;

set PYPATH="%vista_home%/jython/Lib;%vista_home%/lib/Lib;%hec_home%/hec.jar;%hec_home%/hecData.jar;%hec_home%/heclib.jar;%hec_home%/rma.jar;"

set CPATH="%vista_home%/lib/vista.jar;%vista_home%/jython/jython.jar;%vista_home%/lib/jakarta-oro-2.0.8.jar;%vista_home%/lib/pd.jar;%vista_home%/lib/misc.jar;%vista_home%/lib/jhall.jar;%vista_home%/lib/jnios.jar;%vista_home%/lib/widgets.jar;%wrims2_home%/WRIMSv2.jar;%misc_home%/wvscript.jar"

set LPATH="%vista_home%/lib;%hec_home%" -Dvista.home="%vista_home%"

set PYHOME="%vista_home%/jython"

set ARGS=

:loop
if [%1] == [] goto endloop
        set ARGS=%ARGS% %1
        shift
        goto loop
:endloop

rem ###############
rem starting vscript
rem ###############

if defined ARGS goto run2

:run1
%jre_home%\bin\java -Xmx800m  -Djava.library.path=%LPATH% -Dvista.home="%vista_home%" -Dpython.home=%PYHOME% -Dpython.path=%PYPATH% -classpath %CPATH% org.python.util.jython -i "%vista_home%/lib/__init__.py"
goto end

:run2
%jre_home%\bin\java -Xmx800m  -Djava.library.path=%LPATH% -Dvista.home="%vista_home%" -Dpython.home=%PYHOME% -Dpython.path=%PYPATH% -classpath %CPATH% org.python.util.jython -i  %ARGS%

endlocal
:end 
