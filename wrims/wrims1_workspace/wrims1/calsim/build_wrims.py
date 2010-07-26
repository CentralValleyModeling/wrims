import os,subprocess

dirs = ['wreslcoder','wreslcoder\\wresl','app','gui','debug','gym','schematic','msw'] 

batchFile_clean = open('pythonwrite_clean.bat','w')
batchFile_javac = open('pythonwrite_javac.bat','w')
batchFile_copy = open('pythonwrite_copy.bat','w')


cwd = os.getcwd();
print(cwd)
#cwd = cwd+"\\calsim";

#javac = r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac -J"-mx44m" -g -d'
javac = r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac -J"-mx44m" -g '
#javac = r'D:\Java\jdk_x86\jdk1.6.0_21\bin\javac'
jar =   r'D:\Java\jdk_x86\jdk1.6.0_21\bin\jar.exe'
targetpath = r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\classes\calsim'+'\\'
targetpath_m = r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\classes\calsim'
targetLibPath = r'D:\cvwrsm\wrims\wrims1_workspace\wrims1\calsim\lib'+'\\'

classpath = '".;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\..;D:\\Java\\jdk_x86\\jdk1.6.0_21\\lib\\classes.zip;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\vista.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\COM.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\test.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\jhall.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\collections.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\xml.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\JGo.jar;D:\\cvwrsm\\wrims\\wrims1_workspace\\wrims1\\calsim\\lib\\WrimsSchematic.jar"'


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
    newd = cwd+'\\'+dir;
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


writeBatch_jar(targetLibPath+'calsim-help.jar', 'help\\*')

writeBatch_jar(targetLibPath+'calsim.jar', 'classes\\calsim')

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

