

set ConfigFilePath=%1

echo off
for %%F in (%ConfigFilePath%) do set dirname=%%~dpF
set RunDir=%dirname%

rem echo %RunDir%

rem pause

rem set RunDir=%~dp0%studies\callite_svn47\CONV\run
rem set ConfigFilePath=%RunDir%\CONV.config


echo off
:------------------:
: wrims2 lib jars  :
:------------------:
set JarDir=%~dp0%lib\wrims2
set AppJars=%JarDir%\WRIMSv2.jar
set AppJars=%AppJars%;%JarDir%\gurobi.jar
set AppJars=%AppJars%;%JarDir%\heclib.jar
set AppJars=%AppJars%;%JarDir%\jnios.jar
set AppJars=%AppJars%;%JarDir%\jpy.jar
set AppJars=%AppJars%;%JarDir%\misc.jar
set AppJars=%AppJars%;%JarDir%\pd.jar
set AppJars=%AppJars%;%JarDir%\vista.jar
set AppJars=%AppJars%;%JarDir%\lpsolve55j.jar
set AppJars=%AppJars%;%JarDir%\commons-io-2.1.jar
set AppJars=%AppJars%;%JarDir%\javatuples-1.2.jar
set AppJars=%AppJars%;%JarDir%\guava-11.0.2.jar
set AppJars=%AppJars%;%JarDir%\CalLiteV16.jar

:---------------------------------:
: user defined java class and dll :
:---------------------------------:
set ExternalDir=%RunDir%External

:------------:
: class path :
:------------:
set CLASSPATH=-classpath "%ExternalDir%;%AppJars%"

:------------:
: dll path   :
:------------:
set PATH=%ExternalDir%;%JarDir%

:-------------------------------------------------------:
: dir for sty file generation (read by groundwater.dll  :
:-------------------------------------------------------:
set Java_Bin=%~dp0%\lib\jre6\bin\

REM ----------------------------------------------------------


%Java_Bin%java -Xmx1400m -Xss1024K -Djava.library.path=%PATH% %CLASSPATH% wrimsv2.components.ControllerBatch -config="%configFilePath%"
exit
