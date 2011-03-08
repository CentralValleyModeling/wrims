D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files/Java/jdk1.6.0_20/include"  -I"C:/Program Files/Java/jdk1.6.0_20/include/win32" wrimsv2_external_FunctionAnnEC.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared -o InterfaceToAnn.dll wrimsv2_external_FunctionAnnEC.o -L./ ..\dll\Ann7inp_CA.dll
copy InterfaceToAnn.dll ..\dll\InterfaceToAnn.dll
del wrimsv2_external_FunctionAnnEC.o
del InterfaceToAnn.dll
