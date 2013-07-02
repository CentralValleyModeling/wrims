import os
import subprocess
from os.path import dirname
from scripts.tool import Param, DssHec
from scripts.wrims2 import Utils
from process.dssTransferProcess import DssTransferProcess

class Study:

	#cMap = {} #configMap
#	dssMap = {} #dssVarMap
#	
#	_startYear=None
#	_startMonth=None # Specify month in config file. Don't change month here
#	_numberOfSteps=None

	_logger = Param.logger
	
	
	
	def __init__(self, configPath, batFileName='runConfig.bat'):

		
		self._logger = Param.logger
		self._configPath = os.path.join(os.path.dirname(Param.mainScriptPath), configPath)
		print 'configPath:'+self._configPath
		self._configDir = os.path.dirname(self._configPath)
		self._studyName, configExtension = os.path.splitext(os.path.basename(self._configPath))
		print 'studyName: '+self._studyName
		self._ms_configPath = os.path.join( self._configDir, "__generated.config")
		self._batFileName = batFileName
		
		#parse config file and put the map to cMap	
		self._cMap=Utils.getConfigMap(self._configPath)
		self._configKeyList = Utils.configKeyList
		
# 		self._StartYear=int(self.cMap.get("StartYear"))
# 		self._startMonth=int(self.cMap.get("StartMonth"))
# 		self._numberOfSteps=int(self.cMap.get("NumberOfSteps"))
		
		t_initFile=self._cMap.get("InitFile")
		t_svarFile=self._cMap.get("SvarFile")
		t_dvarFile=self._cMap.get("DvarFile")

		t_initFile=t_initFile.replace('\"','').replace('\'','')
		t_svarFile=t_svarFile.replace('\"','').replace('\'','')
		t_dvarFile=t_dvarFile.replace('\"','').replace('\'','')
				
		self._cMap.put("InitFile",t_initFile)
		self._cMap.put("SvarFile",t_svarFile)
		self._cMap.put("DvarFile",t_dvarFile)		

		
# 		self._initFileAbsPath = os.path.join( self.configDir, initFile )
# 		self._svarFileAbsPath = os.path.join( self.configDir, svarFile )
# 		self._dvarFileAbsPath = os.path.join( self.configDir, dvarFile )	

		self._initFPart = self._cMap.get("InitFPart")	
		self._svarFPart = self._cMap.get("SvarFPart")	
			
		self.processList=[]	
		self.processDict={}





	def add_dss_transfer(self, id, destn, destn_Fpart, source=None, transferFile=None ):
		
		dssTransferFile=None
		
		if transferFile!=None:
		
			if "." not in transferFile:
				transferFile = transferFile+".transfer"
		
			dssTransferFile = os.path.join( self.configDir, transferFile )
		
		else:
			
			#transferFile = "DssCopy_"+str(len(self.processList)+1)
			dssTransferFile = None
			
		if source==None:
			
			source = self.DvarFile


		p = DssTransferProcess(source, destn, destn_Fpart, dssTransferFile)
		
		
		self.processList.append(id)
		self.processDict[id]=p		
		
		
		
	def info(self):
		
		#print "Study Name:  "+self.name
		print "configPath: "+self._configPath
		for pn in self.processDict.keys():
			print "processNames: "+pn
		for key in self._configKeyList:
			if self._cMap.get(key):
				print '=> ' + key + ':' + self._cMap.get(key)	
		
	
	def _run_wrims(self,startYear,numberOfSteps):


		# call cmd to run config path
		
		if (startYear != self._startYear) or (numberOfSteps != self._numberOfSteps):
	
			self._logger.info("Write study config:  "+self.ms_configPath)
			# write config file
			Utils.generateConfigFile(self.ms_configPath, self.cMap, startYear=startYear, numberOfSteps=numberOfSteps)
		
			self._logger.info("Run generated config: "+self.ms_configPath)
			
			#subprocess.call([self.batFileName, self.ms_configPath])
			subprocess.call(["cmd.exe", "/c", "start", self.batFileName, self.ms_configPath])
			
		else:
			self._logger.info("Run original config: "+self.configPath)
			#subprocess.call([self.batFileName, self.configPath])	
			subprocess.call(["cmd.exe", "/c", "start", self.batFileName, self.configPath])
			
			
		#subprocess.call(['cmd.exe', '/c', 'RunStudy.bat', self.ms_configPath])


	def _run_process(self,processName,startYear,numberOfSteps):
		
		self._logger.info("Run process: "+processName)
		process=self.processDict[processName]
		
		process.startYear=startYear
		process.startMonth=self._startMonth
		process.numberOfSteps=numberOfSteps
		
		process.run()
		
		
	def run(self, StartYear=None, NumberOfSteps=None):
	
		#self._startYear=startYear
		#self._numberOfSteps=numberOfSteps
		
		if StartYear == None:
			StartYear = self._StartYear
			
		if NumberOfSteps == None:
			NumberOfSteps = self._NumberOfSteps
		
		self._run_wrims(StartYear,NumberOfSteps)
		
		for pn in self.processDict.keys():
			self._run_process(pn, StartYear, NumberOfSteps)
	
	
	def modifyConfig(self, newStudyName, StartYear=None, StartMonth=None, NumberOfSteps=None, SvarFPart=None):
		
		newConfigPath = os.path.join(self._configDir, newStudyName+'.config')
		
		if os.path.exists(newConfigPath):
			print newStudyName+' already exists.'
			return
		
		self._studyName = newStudyName		
		
		if StartYear:
			self._cMap.put('StartYear', StartYear)

		if StartMonth:
			self._cMap.put('StartMonth', StartMonth)
			
		if NumberOfSteps:
			self._cMap.put('NumberOfSteps', NumberOfSteps)

		if SvarFPart:
			self._cMap.put('SvarFPart', SvarFPart)
			
		# write configFile
		cf = open(newConfigPath,'w+')	
		for key in self._configKeyList:
			if self._cMap.get(key):
				cf.write( key + '\t' + str(self._cMap.get(key)) + '\n')	
			


		
			