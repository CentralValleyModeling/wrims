import os



print __file__

Version_ = 'WRIMS v1.3.7 (XA16)'
Version_Nospace_ = 'WRIMS_v1.3.7_XA16'
Version_XA = 'xav16' 

VersionTemplate     = "version=@{Version} SVN:@{Version_SVN} " 
VersionWrapperTemplate = "  CHARACTER(LEN=36), parameter     :: version_identifier = '@{Version} SVN:@{Version_SVN}'"
setupScriptTemplate =   '[Setup] \n' \
					    'AppName              =@{Version} \n' \
						'DefaultGroupName     =@{Version} \n' \
						'AppVerName           =@{Version} \n' \
						'UninstallDisplayName =@{Version} \n' \
						'AppId                =@{Version} \n' \
						'OutputBaseFilename   =@{Version_Nospace}_SVN_@{Version_SVN} \n' \
						'DefaultDirName   =c:\\@{Version_Nospace}    \n' \
						'[Files] \n' \
						'Source: "D:\\Java\\jre_x86\\jre6\\*"; Excludes: ".svn"; DestDir: "{app}\\jre\\"; Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main \n' \
						'[Icons]                                                                             \n' \
						'Name:       "{group}\\@{Version} "; Filename: "{app}\\"                \n' \
						'Name:   "{group}\\Run @{Version} "; Filename: "{app}\\bin\\WRIMS.bat"  \n' \
						'Name:         "{app}\\@{Version} "; Filename: "{app}\\bin\\WRIMS.bat"  \n' \
						'Name: "{userdesktop}\\@{Version} "; Filename: "{app}\\bin\\WRIMS.bat"; Tasks: desktopicon  \n' 

XA_Automake_Template =  'MODULE=. \n'    \
						'FILES=*.f90 \n' \
						'COMPILE=@lf90 -nap -ndal -nchk -ntrace -inln -npca -nsav -nstchk -o3 -nw -nwo -c %fi -MOD %mo -ml msvc -dll -wisk -win \n' \
						'LINK=@lf90 @%rf -exe %ex -ml msvc -mod %mo -dll -wisk -win -nomap -lib ..\wrangler\wrangler.lib,@{Version_XA} \n' \
						'TARGET=simsolver.dll \n'



calsim_path    = os.path.split( __file__)[0]
VersionFile_path    = os.path.join(calsim_path,"version.txt")
VersionWrapperFile_path    = os.path.join(calsim_path,"version_wrapper.inc")
setupScriptFile_path    = os.path.join(calsim_path,"setup_include.iss")
XA_AutomakeFile_path    = os.path.join(calsim_path,"engine","Simsolver","automake.fig")

print calsim_path




VersionFile = open(VersionFile_path, "w") 
VersionWrapperFile = open(VersionWrapperFile_path, "w") 
setupScriptFile = open(setupScriptFile_path, "w") 
XA_AutomakeFile = open(XA_AutomakeFile_path, "w") 

try:
	(dummy, SVNVersion_SourceCode) = os.popen4("svnversion ..//calsim ")
	SVNVersion_SourceCode = SVNVersion_SourceCode.readlines()[0]
	SVNVersion_SourceCode = SVNVersion_SourceCode.strip()
	SVNVersion_SourceCode = SVNVersion_SourceCode.replace(":", "-")
	
	print ' SVN version of wrims:        '+ SVNVersion_SourceCode
	VersionTxt = VersionTemplate.replace("@{Version_SVN}", SVNVersion_SourceCode)
	VersionWrapperTxt = VersionWrapperTemplate.replace("@{Version_SVN}", SVNVersion_SourceCode)
	SetupScriptTxt = setupScriptTemplate.replace("@{Version_SVN}", SVNVersion_SourceCode)

	VersionTxt = VersionTxt.replace("@{Version}", Version_)
	VersionWrapperTxt = VersionWrapperTxt.replace("@{Version}", Version_)
	SetupScriptTxt = SetupScriptTxt.replace("@{Version}", Version_)

	XA_Txt = XA_Automake_Template.replace("@{Version_XA}", Version_XA)
	
	VersionTxt = VersionTxt.replace("@{Version_Nospace}", Version_Nospace_)
	VersionWrapperTxt = VersionWrapperTxt.replace("@{Version_Nospace}", Version_Nospace_)
	SetupScriptTxt = SetupScriptTxt.replace("@{Version_Nospace}", Version_Nospace_)
	
	VersionFile.write(VersionTxt)
	VersionWrapperFile.write(VersionWrapperTxt)
	setupScriptFile.write(SetupScriptTxt)
	XA_AutomakeFile.write(XA_Txt)
	
	VersionFile.close()
	VersionWrapperFile.close()
	setupScriptFile.close()
	XA_AutomakeFile.close()

except:
	VersionFile.close()
	VersionWrapperFile.close()
	setupScriptFile.close()
	XA_AutomakeFile.close()
	os.remove(VersionFile_path) 
	os.remove(VersionWrapperFile_path) 
	os.remove(setupScriptFile_path) 
	os.remove(XA_AutomakeFile) 
	print 'Abort.... possible error in file /calsim/verion_generate.py' 
