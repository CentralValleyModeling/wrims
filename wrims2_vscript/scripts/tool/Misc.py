import shutil
import os


def month2Str(iMonth):
    
    strMonthList=['JAN','FEB','MAR','APR','MAY','JUN','JUL','AUG','SEP','OCT','NOV','DEC']
    
    return strMonthList[iMonth-1]
        

def erase(fileOrDirPath):
    
    try:
        os.remove(fileOrDirPath)
    
    except:
        try:
            shutil.rmtree(fileOrDirPath)
        except:
            pass
        


def copyAll(root_src_dir, root_dst_dir):

    if not os.path.exists(root_dst_dir):
        os.mkdir(root_dst_dir)
    
    for src_dir, dirs, files in os.walk(root_src_dir):
        dst_dir = src_dir.replace(root_src_dir, root_dst_dir)
        if not os.path.exists(dst_dir):
            os.mkdir(dst_dir)
        for file_ in files:
            src_file = os.path.join(src_dir, file_)
            dst_file = os.path.join(dst_dir, file_)
            if os.path.exists(dst_file):
                os.remove(dst_file)
            shutil.copy(src_file, dst_dir)