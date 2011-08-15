import os

Version_Main    = "2.0"  # First two number of 8.0b1
Version_Status  = "beta"   

setupTemplate = open("version.template",'r')


(dummy, Version_SVN) = os.popen4("svnversion ../wrims_v2 ")


Version_SVN = Version_SVN.readlines()[0]

Version_SVN = Version_SVN.strip()


print ' SVN version of ../wrims_v2:                 '+ Version_SVN

try:
	test = int(Version_SVN)

	setupTemplateTxt = setupTemplate.read()
   
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_Main}",   Version_Main)
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_SVN}",    Version_SVN)	
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_Status}", Version_Status)
	
	setupfile = open("bin/version.xml","w")
	setupfile.write(setupTemplateTxt)
	setupfile.close()
        

except:
	print 'Abort.... Try SVN update and commit before generating setup script.'
    
