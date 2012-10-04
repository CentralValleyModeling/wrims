echo off

IF [%1]==[] (
	echo ==================================
	echo # Error: Config file path Missing
	echo ==================================
	pause
	exit
	)
	
set ConfigFilePath=%1

for %%F in (%ConfigFilePath%) do set dirname=%%~dpF
set RunDir=%dirname%run\


echo off

:-------------------------------------------------------:
: dir for sty file generation (read by groundwater.dll) :
:-------------------------------------------------------:

set t=%ConfigFilePath%
set t=%t::=@%
set t=%t:\=$%

set Java_Bin=%~dp0_temp\%t%

IF EXIST %Java_Bin% (
	rmdir /s /q %Java_Bin%
)
 
mkdir %Java_Bin%

set Java_Bin=%~dp0_temp\%t%\

:------------------:
: wrims2 lib jars  :
:------------------:
set JarDir=D:\cvwrsm\trunk\wrims_schematics\lib

set AppJars=..\..\bin
set AppJars=%AppJars%;D:\cvwrsm\trunk\wrims_v2\wrims_v2\src\wrimsv2\lib\antlr-runtime-3.2.jar
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
: call java to run ControllerBatch class                :
:-------------------------------------------------------:



D:\cvwrsm\trunk\3rd_party\jrockit-jre1.6.0_26-R28.1.4\bin\java -Xmx1472m -Xss1280K -Djava.library.path=%PATH% %CLASSPATH% wrimsv2.components.ControllerBatch -config="%configFilePath%"

pause