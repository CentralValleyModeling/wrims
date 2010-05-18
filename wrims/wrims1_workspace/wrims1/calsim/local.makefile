# set these for your locations and platform
# set these for platform Solaris
#CALSIM_HOME = /home/palm/nsandhu/java/calsim2.0/calsim/
#JAVA_HOME = /site/java/jdk
#DELETE = rm -rf 
#CMD_SEP=;
#PATH_SEP=/
#CPATH_SEP=:

# set these for Windows platform
CALSIM_HOME = d:/cvwrsm/models/wrims/wrims13/calsim
JAVA_HOME = d:/jdk/jdk1.6.0_20
DELETE = rm -rf #del
CMD_SEP = ; #&
PATH_SEP = /
CPATH_SEP=;
JAVACC=d:/cvwrsm/models/3rdparty/javacc2.0/bin/javacc.bat
JAVACC_OPTIONS=
MAKE=d:/cvwrsm/models/3rdparty/cygnus/bin/make.exe --unix
JAR = $(JAVA_HOME)${PATH_SEP}bin${PATH_SEP}jar.exe
WEBSTART_LIB=d:/cvwrsm/models/3rdparty/WebstartSDK3.0/classes
