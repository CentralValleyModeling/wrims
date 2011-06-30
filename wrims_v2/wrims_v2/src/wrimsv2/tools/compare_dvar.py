################# configuration ##################

#### common setting
compare_number_of_decimal = 6
total_cycle = 2

#### v1
v1_label_begin = "|"
v1_label_end = "STATISTICS"
v1_begin_line_offset = 0
v1_end_line_offset = -2
v1_infile_path  = "v1.log"

#### v2
v2_label_begin = "|"
v2_label_end = "STATISTICS"
v2_begin_line_offset = 0
v2_end_line_offset = -2
v2_infile_path  = "v2.log"

################# more settings
v1_outfile_prepend = "v1_dvar"
v2_outfile_prepend = "v2_dvar"
max_integer_length = compare_number_of_decimal + 7
################# end configuration ##############



def findObjLineRange(label_begin,label_end,begin_offset,end_offset,infile_path):
## find obj line range
	i_start= []
	i_end = []
	infile = open(infile_path,"r")
	
	in_block_obj = False #false

	for i, line in enumerate(infile.readlines()):

		if ( (in_block_obj == False) and (label_begin in line) ):
			i_start.append(i+begin_offset)
			in_block_obj = True
			
		if ( (in_block_obj == True) and (label_end in line) ):	
			i_end.append(i+end_offset)
			in_block_obj = False
	
	infile.close()
	
	outPosDict = {}
	
	for i, (pos_start, pos_end) in enumerate(zip(i_start,i_end)):
		
		outPosDict[i]= {"start":pos_start, "end":pos_end}
		
	#print outPosDict			
	return outPosDict	

def step1(i_start,i_end,label,label_end,infile_path):

	infile = open(infile_path,"r")
	#outfile = open("V1_obj_step1.log","w")
	outString =""
	for i, line in enumerate(infile.readlines()):
		if (i>= i_start and i<= i_end):
			
			line=line.replace("= FREE", "FREE")
			#outfile.write(line)
			outString=outString+line

	#outfile.close()
	infile.close()
	#print "String: "+ outString
	return outString

def step2(inString):
	
	outDict = {}
	data = []
	#infile = open("V1_obj_step1.log","r")
	infile = inString
	#outfile = open("V1_obj_step2.log","w")
	
	for line in infile.split('\n'):
		#line = line.replace("= 0", "")
		for item in line.split('|'):
			item= item.strip().split()
			#print "item: "+str(item)
			data.append(item)

	outID=[]
	outMax=[]
	outMin=[]
	outIsFree=[]
	
	for item in data:
		
		if len(item)== 5:
			outID.append(item[2])
			min = float(item[0])
			max = float(item[4])
			outMin.append(min)
			outMax.append(max)
			outIsFree.append(False)
			
		elif len(item)== 3:

			try:
				float(item[0])
				outID.append(item[2])
				min = float(item[0])
				outMin.append(min)
				outMax.append("NA")
				
			except:
				outID.append(item[0])
				outMin.append("NA")
				max = float(item[2])
				outMax.append(max)
				
			finally:
				outIsFree.append(False)

				
		elif len(item)==2:
			
			outID.append(item[0])
			outMin.append("NA")
			outMax.append("NA")
			outIsFree.append(True)
			
		elif len(item)>0:
			
			print "#Error: "+str(item)	
				
	for id, min, max, isFree in zip(outID, outMin, outMax, outIsFree):
		

		#print id, min, max, isFree
		outDict[id]=[min,max,isFree]	
		#outfile.writelines(id+' '+str(weight)+'\n')	

	#outfile.close()
	#infile.close()
	
	return outDict

def step3(inDict,outfile_path):
	
	outfile = open(outfile_path,"w")
	
	for k,v in sorted(inDict.items()):
		
		isFree = v[2]
		rangeStr = ""
		
		if isFree:
			rangeStr =  " Free"
			#rangeStr = "{: 12g}".format(v[0])
			
		else:
			
			if v[0]!="NA":
				
				if v[0] == int(v[0]):
					sss = "  Min"+"{:> "+str(max_integer_length)+"g}"
					rangeStr = sss.format(v[0])
				else:
					sss = "{:> "+str(compare_number_of_decimal)+"."+str(compare_number_of_decimal-1)+"e}"
					rangeStr = "  Min "+sss.format(v[0])
					
			else:	
				sss = "{:>"+str(max_integer_length+5)+"}"
				rangeStr = sss.format(" ")
			
				
			if v[1]!="NA":
				
				if v[1] == int(v[1]):
					sss = "  Max"+"{:> "+str(max_integer_length)+"g}"
					rangeStr += sss.format(v[1])
				else:
					sss = "{:> "+str(compare_number_of_decimal)+"."+str(compare_number_of_decimal-1)+"e}"
					rangeStr += "  Max "+sss.format(v[1])				

						
		e = "{0:32}".format(k) + rangeStr
		
		outfile.writelines(e+'\n')	
	outfile.close()	

def wrims1(label_begin,label_end,begin_offset,end_offset,infile_path,outfile_prepend):
	
	out_full_map = {}	
	
	### find line number		
	posDict_global = findObjLineRange(label_begin,label_end,begin_offset,end_offset,infile_path)
		
	print posDict_global
	
	###
	
	for icycle in range(0,total_cycle):
		
		### term to remove
		term_global = "OBJ00"
		term_local  = "OBJ" + "{:02d}".format(icycle+1)
		
		### begin parsing global obj
		outStep1=step1(posDict_global[icycle]["start"],posDict_global[icycle]["end"],label_begin,label_end,infile_path)
		map=step2(outStep1)
				
		### remove OBJ00 
		del map[term_global]
		del map[term_local]
		
					
		merged_map = dict(map.items())
		
		# final output
		out_full_map[icycle] = merged_map
		cycleStr = "_cycle_"+str(icycle+1)
		outfile_path = outfile_prepend + cycleStr + ".txt"
		step3(merged_map,outfile_path)	
		
	return out_full_map
		

def wrims2(label_start,label_end,begin_offset,end_offset,infile_path,outfile_prepend):
	
	out_full_map = {}	
	
	### find line number		
	posDict_global = findObjLineRange(label_start,label_end,begin_offset,end_offset,infile_path)
	
	print posDict_global

	### begin parsing
	for icycle in range(0,total_cycle):
		
		### begin parsing global obj
		outStep1=step1(posDict_global[icycle]["start"],posDict_global[icycle]["end"],label_start,label_end,infile_path)
		map=step2(outStep1)				
					
		merged_map = map
		
		# final output
		out_full_map[icycle] = merged_map
		cycleStr = "_cycle_"+str(icycle+1)
		outfile_path = outfile_prepend + cycleStr + ".txt"
		step3(merged_map,outfile_path)	
		
	return out_full_map
		
### call functions
v1_map = wrims1(v1_label_begin,v1_label_end,v1_begin_line_offset,v1_end_line_offset,v1_infile_path,v1_outfile_prepend)
v2_map = wrims2(v2_label_begin,v2_label_end,v2_begin_line_offset,v2_end_line_offset,v2_infile_path,v2_outfile_prepend)
	