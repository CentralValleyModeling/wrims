REM ----------------------------------------------------------
REM set study config


set StudyDir=%~dp0%studies\callite_svn47
set ConfigFilePath=%StudyDir%\run\test1.config


set JarDir=%~dp0%lib\wrims2

:------------------:
: wrims2 lib jars  :
:------------------:
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

REM ----------------------------------------------------------


jre6\bin\java -Xmx1000m -Xss1024K -Djava.library.path=%PATH% %CLASSPATH% wrimsv2.components.ControllerBatch -config="%configFilePath%"

