import os

Version_Main    = "2.0"  
Version_Status  = "debug"   
Version_SVN     = "99999"

setupTemplate = open("version.template",'r')


print ' Debug build......  '

try:

	setupTemplateTxt = setupTemplate.read()
   
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_Main}",   Version_Main)
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_SVN}",    Version_SVN)	
	setupTemplateTxt = setupTemplateTxt.replace("@{Version_Status}", Version_Status)
	
	setupfile = open("bin/version.xml","w")
	setupfile.write(setupTemplateTxt)
	setupfile.close()
        

except:
	print 'Abort.... Error in generate_version_debug.'
    
