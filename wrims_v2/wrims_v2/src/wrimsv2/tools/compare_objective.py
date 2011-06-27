################# configuration ##################

#### common setting
compare_number_of_decimal = 6
total_cycle = 2

#### v1
v1_label_local = ["01OBJECTIVE:","02OBJECTIVE:"]
v1_label_global = "00OBJECTIVE:"
v1_label_end = "= 0"
v1_begin_line_offset = 0
v1_end_line_offset = 0
v1_infile_path  = "v1.log"

#### v2
v2_label_begin = "Maximize Solve Number"
v2_label_end = "Constraints"
v2_begin_line_offset = 1
v2_end_line_offset = -2
v2_infile_path  = "v2.log"

################# more settings
v1_outfile_prepend = "v1_objective"
v2_outfile_prepend = "v2_objective"

################# end configuration ##############



def findObjLineRange(label,label_end,begin_offset,end_offset,infile_path):
## find obj line range
	i_start= []
	i_end = []
	infile = open(infile_path,"r")
	
	in_block_obj = False #false

	for i, line in enumerate(infile.readlines()):

		if ( label in line):
			i_start.append(i+begin_offset)
			in_block_obj = True
			
		if ( in_block_obj == True and (label_end in line) ):	
			i_end.append(i+end_offset)
			in_block_obj = False
	
	infile.close()
	
	outPosDict = {}
	
	for i, (pos_start, pos_end) in enumerate(zip(i_start,i_end)):
		
		outPosDict[i]= {"start":pos_start, "end":pos_end}
		
	#print outPosDict			
	return outPosDict	

def step1(i_start,i_end,label,label_end,infile_path):
## remove "+"; 
## remove space between "-" and number
## remove label
 
	infile = open(infile_path,"r")
	#outfile = open("V1_obj_step1.log","w")
	outString =""
	for i, line in enumerate(infile.readlines()):
		if (i>= i_start and i<= i_end):
			
			line=line.replace(label, "")
			line=line.replace(label_end,"")
			line=line.replace("- ", "-")
			line=line.replace("+", " ")
			#outfile.write(line)
			outString=outString+line

	#outfile.close()
	infile.close()
	return outString

def step2(inString):
## correct id with weight==1 and correct minus sign
	
	outDict = {}
	data = []
	#infile = open("V1_obj_step1.log","r")
	infile = inString
	#outfile = open("V1_obj_step2.log","w")
	
	for line in infile.split('\n'):
		#line = line.replace("= 0", "")
		line = line.strip().split()
		for item in line:
			data.append(item)

	outID=[]
	outWeight=[]
	findID = False
	
	for item in data:
		
		if findID:
			try:
				float(item)
				print "Error! two consecutive numbers: "+item
			
			except:
				outID.append(item)
				findID = False
				
		else: #find weight
			try: 
				weight = float(item)
				outWeight.append(weight)	
				findID = True
		
			except:
				outWeight.append(1)
				outID.append(item)
				findID = False
				
	for id, weight in zip(outID, outWeight):
		
		isInteger = False
		
		# use integer format when possible
		int_weight = int(weight)
		if weight == int_weight:
			weight = int_weight
			isInteger = True
		else:
			isInteger = False
		
		# correct minus sign
		if id[0]=="-":
			id=id[1:]
			weight = -weight		
			
		outDict[id]=[weight, isInteger]	
		#outfile.writelines(id+' '+str(weight)+'\n')	

	#outfile.close()
	#infile.close()
	
	return outDict

def step3(inDict,outfile_path):
	
	outfile = open(outfile_path,"w")
	
	for k,v in sorted(inDict.items()):
		
		isInteger = v[1]
		
		if isInteger:
			numberStr = "{: 12g}".format(v[0])
			
		else:
			sss = "{: "+str(compare_number_of_decimal)+"."+str(compare_number_of_decimal-1)+"e}"
			numberStr = sss.format(v[0])
			
		e = "{0:32}".format(k) + numberStr
		
		outfile.writelines(e+'\n')	
	outfile.close()	

def wrims1(label_global,label_local,label_end,begin_offset,end_offset,infile_path,outfile_prepend):
	
	out_full_map = {}	
	
	### find line number		
	posDict_global = findObjLineRange(label_global,label_end,begin_offset,end_offset,infile_path)
	posDict_local ={}
	
	for icycle, label in enumerate(label_local):
		posDict_local[icycle] = findObjLineRange(label,label_end,begin_offset,end_offset,infile_path)[0]
	
	print posDict_global
	print posDict_local
	
	###
	
	for icycle in range(0,total_cycle):
		
		### term to remove
		term_global = "OBJ00"
		term_local  = "OBJ" + "{:02d}".format(icycle+1)
		
		print term_local
		
		### begin parsing global obj
		outStep1=step1(posDict_global[icycle]["start"],posDict_global[icycle]["end"],label_global,label_end,infile_path)
		map_global=step2(outStep1)
		
		### remove OBJ00 
		if map_global[term_global][0] == -1:
			del map_global[term_global]
		else:
			print "Error global term."
			print map_global[term_global]		
				
		### begin parsing local obj
		outStep1=step1(posDict_local[icycle]["start"],posDict_local[icycle]["end"],label_local[icycle],label_end,infile_path)
		map_local=step2(outStep1)
		
		### remove OBJ0X 
		if map_local[term_local][0] == -1:
			del map_local[term_local]
		else:
			print "Error local term."
			print map_local[term_local]
					
		merged_map = dict(map_global.items() + map_local.items())
		
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

		### remove "OBJ:"
		term_global = "OBJ:" 
		
		if map[term_global][0] == 1:
			del map[term_global]
		else:
			print "Error global term."
			print map[term_global]					

					
		merged_map = map
		
		# final output
		out_full_map[icycle] = merged_map
		cycleStr = "_cycle_"+str(icycle+1)
		outfile_path = outfile_prepend + cycleStr + ".txt"
		step3(merged_map,outfile_path)	
		
	return out_full_map
		
### call functions
v1_map = wrims1(v1_label_global,v1_label_local,v1_label_end,v1_begin_line_offset,v1_end_line_offset,v1_infile_path,v1_outfile_prepend)
v2_map = wrims2(v2_label_begin,v2_label_end,v2_begin_line_offset,v2_end_line_offset,v2_infile_path,v2_outfile_prepend)
	