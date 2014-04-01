####################################################################################################
# Step 0. Install Paraview software (http://www.paraview.org/paraview/resources/software.php)
# Step 1. Use a text editor to open this file: .\calsim3\common\CVGroundwater\Data\CVGroundwater.in
# Step 2. Uncomment and rename the groundwater head output file to "Head.txt" (around line# 39)
# Step 3. Modify the following path to match your CalSim3 DSS output directory

outDir = r'D:\cvwrsm\trunk\calsim30\calsim30_bo\conv\DSS'

# Step 4. Run CalSim3
# Step 5. Run ParaView
# Step 6. Click "Tools" -> "Python Shell"
# Step 7. Click "Run Script" and then choose this python script

# In lieu of Step 6 and 7, you can click "Macros" -> "Add new macro" and then choose this script
####################################################################################################


from os import path
import collections

gwDir = path.realpath(path.join(outDir,"../../common/CVGroundwater/Data"))
print outDir 
print gwDir
nodeFile      = path.join(gwDir, 'CVnode.dat')
elementFile   = path.join(gwDir, 'CVelement.dat')
nodeValueFile = path.join(outDir,'Head.txt')
totalLayer    = 3
extractLayer  = 2 
vtkFilePrepend  = 'Head'

ND=0
FACTOR=0
NODEMAP={}

NE=0
TNE=0
ELEMENTMAP={}

TIME=[]
VALUEMAP={}

def pMacro(vtkFiles):

	paraview.simple._DisableFirstRenderCameraReset()

	out_ = LegacyVTKReader( FileNames=vtkFiles )
	AnimationScene1 = GetAnimationScene()
	AnimationScene1.EndTime = 11.0
	AnimationScene1.PlayMode = 'Snap To TimeSteps'

	RenderView1 = GetRenderView()
	RenderView1.CameraFocalPoint = [712755.5, 4185780.5, 0.0]
	RenderView1.CameraPosition = [712755.5, 4185780.5, 10000.0]
	RenderView1.InteractionMode = '2D'
	RenderView1.CenterOfRotation = [712755.5, 4185780.5, 0.0]

	DataRepresentation1 = Show()
	DataRepresentation1.EdgeColor = [0.0, 0.0, 0.5000076295109483]
	DataRepresentation1.SelectionPointFieldDataArrayName = 'head'
	DataRepresentation1.ColorArrayName = ('POINT_DATA', 'head')
	DataRepresentation1.ScalarOpacityUnitDistance = 65014.13800381384
	DataRepresentation1.ScaleFactor = 62932.100000000006

	a1_head_PVLookupTable = GetLookupTableForArray( "head", 1, RGBPoints=[-114.29199981689453, 0.23, 0.299, 0.754, 525.3270835876465, 0.865, 0.865, 0.865, 1164.9461669921875, 0.706, 0.016, 0.15], VectorMode='Magnitude', NanColor=[0.25, 0.0, 0.0], ColorSpace='Diverging', ScalarRangeInitialized=1.0 )

	a1_head_PiecewiseFunction = CreatePiecewiseFunction( Points=[-114.29199981689453, 0.0, 0.5, 0.0, 1164.9461669921875, 1.0, 0.5, 0.0] )

	DataRepresentation1.ScalarOpacityFunction = a1_head_PiecewiseFunction
	DataRepresentation1.LookupTable = a1_head_PVLookupTable

	a1_head_PVLookupTable.ScalarOpacityFunction = a1_head_PiecewiseFunction

	RenderView1.CameraPosition = [712755.5, 4185780.5, 1402365.8507819802]
	RenderView1.CameraClippingRange = [1388342.1922741605, 1423401.3385437098]
	RenderView1.CameraParallelScale = 362958.9903837762

	a1_head_PVLookupTable = GetLookupTableForArray( "head", 1, NanColor=[1.0, 1.0, 0.0], RGBPoints=[-114.29199981689453, 0.278431, 0.278431, 0.858824, 68.63905803680419, 0.0, 0.0, 0.360784, 250.29087772369382, 0.0, 1.0, 1.0, 434.50117374420165, 0.0, 0.501961, 0.0, 616.1529934310912, 1.0, 1.0, 0.0, 799.08405128479, 1.0, 0.380392, 0.0, 982.0151091384887, 0.419608, 0.0, 0.0, 1164.9461669921875, 0.878431, 0.301961, 0.301961], ColorSpace='RGB' )

	RenderView1 = GetRenderView()

	ScalarBarWidgetRepresentation1 = CreateScalarBar( Title='head', LabelFontSize=12, Enabled=1, LookupTable=a1_head_PVLookupTable, TitleFontSize=12 )
	GetRenderView().Representations.append(ScalarBarWidgetRepresentation1)

	LegacyVTKReader1 = GetActiveSource()

	my_representation0 = GetDisplayProperties( LegacyVTKReader1 )

	Render()


def readNodes():

	nf = open(nodeFile,'r')
	
	lines = []
	
	for line in nf:
		if not line.startswith("C"):
			lines.append(line.rstrip())
	
	nd = lines[0].split()[0]
	factor = lines[1].split()[0]
	
	#print nd
	#print factor		
	#raw_input("Press ENTER to exit")
			
	
			
	node = {}
	for line in lines[2:]:
		id = line.split()[0]
		x  = line.split()[1]
		y  = line.split()[2]

		
		e = (float(x), float(y))
		
		node[int(id)] = e
	
	nf.close()
	return (int(nd), float(factor), node)

def readElements():

	ef = open(elementFile,'r')
	
	lines = []
	
	for line in ef:
		if not line.startswith("C"):
			lines.append(line.rstrip())
	
	ne = lines[0].split()[0]
	
	#print ne
	#raw_input("Press ENTER to exit")
			
	element = {}
	totalData = 0
	for line in lines[1:]:
		id = line.split()[0]
		n1  = int(line.split()[1])-1
		n2  = int(line.split()[2])-1
		n3  = int(line.split()[3])-1
		n4  = int(line.split()[4])
		
		if int(n4)==0:
			shape = 3
			e = (shape, n1, n2, n3)
		else:
			shape = 4
			e = (shape, n1, n2, n3, n4-1)
		
		element[int(id)] = e
		totalData = totalData + shape + 1
			
	ef.close()
	return (int(ne), totalData, element)

	
def readNodeValues():

	nf = open(nodeValueFile,'r')
	
	lines = []
	
	for udx, line in enumerate(nf):
		if not line.startswith("*"):
			lines.append(line.rstrip())
			
	
			
	ts = {}    # dictionary  [time_index](value1, value2, value3, ...)
	#value = {} #             [layer][time_index](value1, value2, value3, ...)
	time = []
	
	# second layer  i=1...
	# seq
	for i in range(0, len(lines)/totalLayer):
		
		# time of data to extract
		timeLabel = lines[i*3].split()[0]
		timeLabel=timeLabel.replace('_','/')
		timeLabel=timeLabel.split('/')
		print 'timeLabel:',timeLabel
		timeLabel = timeLabel[2]+' / '+timeLabel[0]
		print 'timeLabel:',timeLabel
		time.append(timeLabel)
		
		# layer of scalar to extract
		line = lines[i*3+extractLayer-1].split()
		ts[i] = line[0:]

	
	nf.close()
	return (time, ts)

	
def fileVTK(step, time):
	f = vtkFilePrepend+'_'+str(step)+'.vtk'
	filePath = path.join(outDir,f)
	vf = open(filePath, 'w')
	vf.write('# vtk DataFile Version 3.0\n')
	vf.write('2D Unstructured Grid of Linear Triangles\n')
	vf.write('ASCII\n\n')
	vf.write('DATASET UNSTRUCTURED_GRID\n')
	vf.write('FIELD FieldData 1\n')
	vf.write('TIME 1 1 string\n')
	vf.write(str(time)+'\n')
	vf.write('POINTS '+str(ND)+' float\n')
	
	for i in range(0,ND):
		x=NODEMAP[i+1][0]
		y=NODEMAP[i+1][1]
		z='0'
		vf.write(str(x)+' '+str(y)+' '+z+'\n')
	
	totalElementData = 0
	vf.write('CELLS '+str(NE)+' '+str(TNE)+'\n')
	for i in range(0,NE):
		shape=ELEMENTMAP[i+1][0]
		n1=ELEMENTMAP[i+1][1]
		n2=ELEMENTMAP[i+1][2]
		n3=ELEMENTMAP[i+1][3]
		if shape==3:
			vf.write(str(shape)+' '+str(n1)+' '+str(n2)+' '+str(n3)+'\n')
		else:
			n4 = ELEMENTMAP[i+1][4]
			vf.write(str(shape)+' '+str(n1)+' '+str(n2)+' '+str(n3)+' '+str(n4)+'\n')
			
	vf.write('CELL_TYPES '+str(NE)+'\n')
	for i in range(0,NE):
		shape=ELEMENTMAP[i+1][0]
		if shape==3:
			type='5'
		elif shape==4:
			type='9'
		vf.write(type+'\n')
			
	vf.write('POINT_DATA '+str(ND)+' \n')
	vf.write('SCALARS head float\n')
	vf.write('LOOKUP_TABLE default\n')
	for i in range(0,ND):
		#print i, ND, VALUEMAP[2][i]
		vf.write(VALUEMAP[step][i]+'\n')

	vf.close()
	return filePath
	
(ND, FACTOR, NODEMAP)=readNodes()
(NE, TNE, ELEMENTMAP)=readElements()
(TIME, VALUEMAP)=readNodeValues()

vtkFiles =[]
for step, time in enumerate(TIME):
	vtkFiles.append(fileVTK(step,time))

pMacro(vtkFiles)

print 'Done!'


