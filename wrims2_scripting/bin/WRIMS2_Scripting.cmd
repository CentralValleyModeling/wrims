@echo off
set jython_bin=%~dp0%..\lib\jython252\bin
set hec_dll=%~dp0%..\lib\hecdss
set jre6_bin=%~dp0%..\lib\jre6\bin
set wrims13_lib=%~dp0%..\lib\wrims13
set path=%wrims13_lib%;%jython_bin%;%hec_dll%;%jre6_bin%;%SystemRoot%\system32;
cd ..
rem echo %path%
cmd.exe
