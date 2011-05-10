import os,subprocess
from collections import defaultdict




rccfile=open('rccfile.txt','r') # read only
outfile=open('rcc_reformatted.txt','w') # write


data = rccfile.readlines()

goal = defaultdict(list)
dvar = defaultdict(list)

r = []
s=""
title=""

di = 0
gi = 0

for line in data:
	
	e = line.strip().split()
	
	if ("@endfile" in e[0]):
		
		if (title == "MAX" or title =="MIN"):
			dvar[di].append(title)
			dvar[di].append(s)
			di = di+1
		else:
			goal[gi].append(title)
			goal[gi].append(s)
			gi = gi+1
			
	elif ( title != e[0]  ):

		if (title == "MAX" or title =="MIN"):
			dvar[di].append(title)
			dvar[di].append(s)
			di = di+1
		else:
			goal[gi].append(title)
			goal[gi].append(s)
			gi = gi+1
	
		s =  e[0] + " : " + e[1] + " | " +e[2]
		title = e[0]		
	else: 	
		if (e[1] == "Max"):
			s =  s + " : " + "<" + " ; " +e[2]
		elif (e[1] == "Min"):
			s =  s + " : " + ">" + " ; " +e[2]
		elif (e[1] == "Fix" or e[1] == "FIX"):
			s =  s + " : " + "=" + " ; " +e[2]			
		else:
			s =  s + " ; " + e[1] + " | " +e[2]
	
	
for j in range(1,len(goal)):

	print j, goal[j]
	print "\n"
	
	outfile.writelines( goal[j][1] + "\n")

