import os
import sys




def copyYearlyTableToFuture(inTablePath, outTablePath, beginYR, sequentialYRs, futureYR):
    
    absInPath = os.path.join(sys.path[0], inTablePath)
    absOutPath = os.path.join(sys.path[0], outTablePath)
    
    if not os.path.exists(os.path.dirname(absOutPath)):
        os.makedirs(os.path.dirname(absOutPath))
    
    outTableFile = open(absOutPath, "w+")
    inTableFile = open(absInPath, "r")
    
    

    data = inTableFile.read()
    
    data = data.split('\n')
    
    # remove empty lines    
    data = [line for line in data if line.strip()]
    
    # map water year type to water year
    dataWY = {} 

    for line in data:

        # copy whole content except empty lines
        outTableFile.write(line+'\n')
        
        # check valid item
        element = line.strip().split()
        try:
            WY = int(element[0])

            if WY >= 1920:
                dataWY[WY] = line

        except:
            continue

    #outTableFile.writelines( '\n' ) # cause error in wrims2 table reading
    
    for i, year in enumerate(range(beginYR, beginYR + sequentialYRs)):
         
        outTableFile.write( str(futureYR+i) + dataWY[year][4:] + "   ! copied from "+str(year) + "\n")


    inTableFile.close()
    outTableFile.close()
    

    
    
