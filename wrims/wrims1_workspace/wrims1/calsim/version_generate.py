import os



print __file__

Version_ = 'WRIMS v1.3.4 beta (XA16)'
Version_Nospace_ = 'WRIMS_v1.3.4_beta_XA16'

#VersionTemplate     = "      character*16 :: dsm2_version = '8.0.4', svn_build = '@{Version_SVN}' " 
VersionTemplate     = "version=@{Version} SVN:@{Version_SVN} " 
VersionWrapperTemplate = "  CHARACTER(LEN=36), parameter     :: version_identifier = '@{Version} SVN:@{Version_SVN}'"
setupScriptTemplate =   '[Setup] \n' \
					    'AppName              =WRIMS @{Version} \n' \
						'DefaultGroupName     =WRIMS @{Version} \n' \
						'AppVerName           =WRIMS @{Version} \n' \
						'UninstallDisplayName =WRIMS @{Version} \n' \
						'AppId                =WRIMS @{Version} \n' \
						'OutputBaseFilename   =WRIMS_@{Version_Nospace}_SVN_@{Version_SVN} \n' \
						'DefaultDirName   =c:\\@{Version_Nospace}    \n' \
						'[Files] \n' \
						'Source: "D:\\Java\\jre_x86\\jre6\\*"; Excludes: ".svn"; DestDir: "{app}\\jre\\"; Flags: ignoreversion recursesubdirs createallsubdirs ; Components: main \n' \
						'[Icons]                                                                             \n' \
						'Name:       "{group}\\@{Version} "; Filename: "{app}\\"                \n' \
						'Name:   "{group}\\Run @{Version} "; Filename: "{app}\\bin\\WRIMS.bat"  \n' \
						'Name:         "{app}\\@{Version} "; Filename: "{app}\\bin\\WRIMS.bat"  \n' \
						'Name: "{userdesktop}\\@{Version} "; Filename: "{app}\\bin\\WRIMS.bat"; Tasks: desktopicon  \n' 
calsim_path    = os.path.split( __file__)[0]
VersionFile_path    = os.path.join(calsim_path,"version.txt")
VersionWrapperFile_path    = os.path.join(calsim_path,"version_wrapper.inc")
setupScriptFile_path    = os.path.join(calsim_path,"setup_include.iss")

print calsim_path




VersionFile = open(VersionFile_path, "w") 
VersionWrapperFile = open(VersionWrapperFile_path, "w") 
setupScriptFile = open(setupScriptFile_path, "w") 

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

	VersionTxt = VersionTxt.replace("@{Version_Nospace}", Version_Nospace_)
	VersionWrapperTxt = VersionWrapperTxt.replace("@{Version_Nospace}", Version_Nospace_)
	SetupScriptTxt = SetupScriptTxt.replace("@{Version_Nospace}", Version_Nospace_)
	
	VersionFile.write(VersionTxt)
	VersionWrapperFile.write(VersionWrapperTxt)
	setupScriptFile.write(SetupScriptTxt)
	
	VersionFile.close()
	VersionWrapperFile.close()
	setupScriptFile.close()

except:
	VersionFile.close()
	VersionWrapperFile.close()
	setupScriptFile.close()
	os.remove(VersionFile_path) 
	os.remove(VersionWrapperFile_path) 
	os.remove(setupScriptFile_path) 
	print 'Abort.... possible error in file /calsim/verion_generate.py' 
