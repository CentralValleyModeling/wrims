REM ----------------------------------------------------------
REM set study config

set StudyDir=%~dp0%studies\callite_svn47\CONV
set ConfigFilePath=%StudyDir%\run\CONV.config



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
set AppJars=%AppJars%;%JarDir%\XAOptimizer.jar

:------------:
: class path :
:------------:
set ExternalDir=%StudyDir%\run\External
set CLASSPATH=-classpath "%ExternalDir%;%AppJars%"

:------------:
: dll path   :
:------------:
set PATH=%ExternalDir%;%JarDir%

:----------------------:
: generated sty path   :
:----------------------:
set Java_Bin=%~dp0%\lib\jre6\bin\

REM ----------------------------------------------------------


%Java_Bin%java -Xmx1000m -Xss1024K -Djava.library.path=%PATH% %CLASSPATH% wrimsv2.components.ControllerBatch -config="%configFilePath%"

