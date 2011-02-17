@echo off
rem ###################################
rem Batch file for running converter
rem ###################################
setlocal
set converter_home=%~dp0
rem echo %converter_home%
if exist "%converter_home%/libs/antlr-3.2.jar" goto :check2

:notfound

echo ############################################################
echo   Error: antlr-3.2.jar files not found
echo ############################################################
pause
goto :end

:check2

if exist "%converter_home%/libs/converter.jar" goto :start

echo ############################################################
echo   Error: converter.jar files not found
echo ############################################################
pause
goto :end

:start
"%converter_home%/jre6/bin/java" -Xmx512m -cp "%converter_home%/libs/antlr-3.2.jar;%converter_home%/libs/converter.jar" main.MainConverter %1%
:end
endlocal 
rem 
