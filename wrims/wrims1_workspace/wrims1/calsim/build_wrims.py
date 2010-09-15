import os,subprocess
import version_file

def version_generate(versionWRIMS, versionXA):

	Version_ = 'WRIMS v' + versionWRIMS + ' ('+versionXA+')'
	Version_Nospace_ = 'WRIMS_v' + versionWRIMS +'_' + versionXA
	#Version_XA = version_file.Version_XA #'xav13' 
	
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
							'LINK=@lf90 @%rf -exe %ex -ml msvc -mod %mo -dll -wisk -win -nomap -lib ..\wrangler\wrangler.lib,@{versionXA} \n' \
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
	
		XA_Txt = XA_Automake_Template.replace("@{versionXA}", versionXA)
		
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

def clean(_targetP,pattern):


    files = _targetP+pattern
#    print ('-> delete files: '+files);
    #os.remove('*.class')
    #subprocess.call(['cmd', '/c', 'del', ' /q ', files ])
    batchFile_clean.write('del /q '+files+'\n\n')

def delete_folder(target):


    print ('-> delete folder: '+target);
    #os.remove('*.class')
    #subprocess.call(['cmd', '/c', 'rmdir', ' /s /q/ ', target ])
    batchFile_clean.write('rmdir /s /q '+target+'\n\n')

def writeBatch_javac(dir):
    newd = calsim_path+dir;
    print(newd);
    files = newd+'\\'+'*.java'
    #os.chdir(newd)
    #subprocess.call([javac, '-classpath', classpath, '*.java' ])

    batchFile_javac.write(javac+' -classpath '+classpath+' '+files+'\n\n')
    #subprocess.call([javac, '-classpath', classpath, files ])

def writeBatch_javac_exclude(_target):

    batchFile_javac.write('del /q '+_target+'\n\n')
		
def writeBatch_copy(_targetP,source):
    #newd = cwd+'\\'+dir;
    #print(newd);
    #files = newd+source
    #os.chdir(newd)
    #subprocess.call([javac, '-classpath', classpath, '*.java' ])

    batchFile_copy.write('xcopy '+source+' '+_targetP+' /y'+'\n\n')
    #subprocess.call([javac, '-classpath', classpath, files ])

def writeBatch_jar(target, source):

    batchFile_copy.write(jar+' -cf '+target+' '+source+'\n\n')

version_generate(version_file.versionWRIMS, version_file.versionXA)
	
#cwd = os.path.split( __file__)[0];
calsim_path    = os.path.split( __file__)[0]+'\\'


dirs = ['wreslcoder','wreslcoder\\wresl','app','gui','debug','gym','schematic','msw'] 

batchFile_clean = open(calsim_path+'pythonwrite_clean.bat','w')
batchFile_javac = open(calsim_path+'pythonwrite_javac.bat','w')
batchFile_copy = open(calsim_path+'pythonwrite_copy.bat','w')



#print(cwd)
#cwd = cwd+"\\calsim";

#javac = r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac -J"-mx44m" -g -d'
javac = version_file.javac #= r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac -J"-mx44m" -g '
#javac = r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac'
jar = version_file.jar #r'D:\Java\jdk_x86\jdk1.6.0_21\bin\jar.exe'
targetpath = version_file.targetpath #r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\classes\calsim'+'\\'
targetpath_m = version_file.targetpath_m #r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\classes\calsim'
targetLibPath = version_file.targetLibPath #r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\lib'+'\\'

classpath = version_file.classpath #'".;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\..;D:\\Java\\jdk_x86\\jdk1.6.0_21\\lib\\classes.zip;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\vista.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\COM.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\test.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\jhall.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\collections.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\xml.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\JGo.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\WrimsSchematic.jar"'


		
#for dir in dirs:
#    clean(dir+'\\','*.class')
#print '========================'

clean('classes\\calsim\\','*')
clean('classes\\','*')

#print '========================'
delete_folder(targetpath)
#clean('help\\','*.jar')
clean(targetLibPath,'calsim.jar')
clean(targetLibPath,'calsim-help.jar')


for dir in dirs:
    writeBatch_javac(dir)

writeBatch_javac_exclude('msw\\DSSDataWriter.class')	
writeBatch_javac_exclude('msw\\ExampleFileFilter.class')	
writeBatch_javac_exclude('gym\\StorageSubNode.class')	
writeBatch_javac_exclude('gym\\PointNode.class')	
writeBatch_javac_exclude('gui\\InputFrame$1.class')	
writeBatch_javac_exclude('gui\\InputFrame.class')	
writeBatch_javac_exclude('gui\\InputPropertyFrame$1.class')	
writeBatch_javac_exclude('gui\\InputPropertyFrame.class')	
writeBatch_javac_exclude('gui\\InputSchematicPanel.class')	
	
for dir in dirs:
    writeBatch_copy(targetpath+dir+'\\',dir+'\\*.class')

writeBatch_copy(targetpath,'version.txt')
writeBatch_copy(targetpath+'app\\data\\',         'app\\data\\*.table')
writeBatch_copy(targetpath+'app\\',               'app\\*.props')
writeBatch_copy(targetpath+'schematic\\',         'schematic\\*.gif')
writeBatch_copy(targetpath+'gui\\',               'gui\\*.gif')

batchFile_copy.write('cd help \n')
writeBatch_jar(targetLibPath+'calsim-help.jar', '*')
batchFile_copy.write('cd .. \n')

batchFile_copy.write('cd classes \n')
writeBatch_jar(targetLibPath+'calsim.jar', 'calsim')
batchFile_copy.write('cd .. \n')


batchFile_clean.close()
batchFile_javac.close()
batchFile_copy.close()


subprocess.call(['pythonwrite_clean.bat' ])
subprocess.call(['pythonwrite_clean.bat' ])
os.chdir(calsim_path+'engine')
subprocess.call(['set_path_build.bat' ])
os.chdir(calsim_path)
subprocess.call(['pythonwrite_javac.bat' ])
subprocess.call(['pythonwrite_copy.bat' ])

os.chdir(calsim_path+'installer')
subprocess.call(['compile_package.bat' ])

#compile('gui')


# subprocess.call(['clean.bat' ])
# subprocess.call(['cmd','\c','am' ])
# subprocess.call(['install.bat' ])

# newd = cwd+"\\Simsolver";
# print(newd);
# os.chdir(newd)

# subprocess.call(['clean.bat' ])
# subprocess.call(['cmd','\c','am' ])
# subprocess.call(['install.bat' ])

# newd = cwd+"\\calsim_main";
# print(newd);
# os.chdir(newd)

# subprocess.call(['clean.bat' ])
# subprocess.call(['cmd','\c','am' ])
# subprocess.call(['install.bat' ])

# newd = cwd+"\\mkcode";
# print(newd);
# os.chdir(newd)

# subprocess.call(['clean.bat' ])
# subprocess.call(['cmd','\c','am' ])
# subprocess.call(['install.bat' ])

# cwd2 = os.getcwd();
# print(cwd2);

