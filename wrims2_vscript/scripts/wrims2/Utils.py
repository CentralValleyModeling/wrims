import os
import scripts.tool.Param as Param
import wrimsv2.evaluator.TimeOperation as TimeOp
from scripting.element import ConfigReader

configKeyList = ["MainFile", 
             "Solver",
             "InitFile",
             "InitFPart",
             "SvarFile",
             "SvarAPart",
             "SvarFPart",
             "DvarFile",                   
             "TimeStep",
             "StartYear", 
             "StartMonth",
             "StartDay",
             "NumberOfSteps",
             "EndYear",
             "EndMonth",
             "EndDay",
             "GroundwaterDir",
             "ShowWreslLog"]

def  getConfigMap(filePath):
        
    cp = ConfigReader(configKeyList);
    cp.parseFile(filePath)

    return cp.configMap


def generateConfigFile(filePath, cMap, startYear, numberOfSteps):
    
    
    cfile = open(filePath,"w")
    cfile.write("Begin Config\n")
    
    for key in cMap.keySet():
        
        if (key=="StartYear"):
            cfile.write(key+"    "+str(startYear)+"\n")
        elif (key=="NumberOfSteps"): 
            cfile.write(key+"    "+str(numberOfSteps)+"\n")
        else:    
            cfile.write(key+"    "+cMap.get(key)+"\n")
    
    cfile.write("End Config\n")
    cfile.close()

def writeConfigFile(filePath,cMap):
    
    cfile = open(filePath,"w")
    cfile.write("Begin Config\n")
    
    for key in cMap.keySet():
        cfile.write(key+"    "+cMap.get(key)+"\n")
    
    cfile.write("End Config\n")
    cfile.close()
    

def deleteFile(directory, extensionToDelete):
    
    for item in os.listdir(directory):
        filePath = os.path.join(directory, item)
        if os.path.isfile(filePath):
            #print item
            extension = os.path.splitext(item)[1]
            #print extension
            if extensionToDelete in extension:
                # print "File deleted: "+item
                try: 
                    os.remove(filePath)
                    Param.logger.warning("File deleted: "+filePath)
                except:
                    pass
               
        
def arrayShift(inArray, shift): 

    outArray = map(lambda x: x+shift, inArray) 
    return outArray


    
    
