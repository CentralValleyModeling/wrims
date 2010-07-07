from ctypes import *

class PyExample(Structure):
  _fields_ = [
				('a', c_int),
				('b', c_float),
				('c', c_char*9),
                 ]


PyDoubleArray = (c_double * 10)()

                 
mydll = windll.LoadLibrary("project//Debug//pycallfortrandll.dll")

PyE = PyExample()
PyE.a = 2
PyE.b = 3.
PyE.c = "Test56789"

for i in range(0,10):
   PyDoubleArray[i]=i*3


mydll.DEMOFORTRAN(byref(PyE),byref(PyDoubleArray))

print "============================================="
print "In Python......\n"
print "a, b, c \n"
print PyE.a
print PyE.b
print ">" + PyE.c + "<"
print "Array"
for i in range(0,10):
    print PyDoubleArray[i]
