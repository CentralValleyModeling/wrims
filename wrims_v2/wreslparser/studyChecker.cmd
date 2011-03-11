@echo off
rem ###################################
rem Batch file for running converter
rem ###################################
setlocal
set studyChecker_home=%~dp0
rem echo %studyChecker_home%
if exist "%studyChecker_home%/libs/antlr-3.2.jar" goto :check2

:notfound

echo ############################################################
echo   Error: antlr-3.2.jar files not found
echo ############################################################
pause
goto :end

:check2

if exist "%studyChecker_home%/libs/studyChecker.jar" goto :start

echo ############################################################
echo   Error: studyChecker.jar files not found
echo ############################################################
pause
goto :end

:start
"%studyChecker_home%/jre6/bin/java" -Xmx512m -cp "%studyChecker_home%/libs/antlr-3.2.jar;%studyChecker_home%/libs/studyChecker.jar" main.StudyChecker %1%
:end
endlocal 
rem 
