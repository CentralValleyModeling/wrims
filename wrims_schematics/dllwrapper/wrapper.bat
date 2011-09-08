@echo off
set control_file=D:/cvwrsm/trunk/wrims_schematics/build/dist/wrimsv2_SGDev/dllwrapper/generateInerfaceAnn.txt

set wrims_home=%~dp0/..
set JNILIB=%wrims_home%/lib

"%wrims_home%/jre6/bin/java" -Djava.library.path="%JNILIB%" -cp "%JNILIB%/WRIMSv2.jar" wrimsv2.external.GenerateCompileFiles "%control_file%" %~dp0
processDll

