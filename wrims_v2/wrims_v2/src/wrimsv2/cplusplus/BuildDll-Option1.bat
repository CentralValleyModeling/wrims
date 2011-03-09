copy ..\dll\Ann7inp_CA.dll Ann7inp_CA.dll 
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files/Java/jdk1.6.0_20/include"  -I"C:/Program Files/Java/jdk1.6.0_20/include/win32" wrimsv2_external_FunctionAnnEC.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files/Java/jdk1.6.0_20/include"  -I"C:/Program Files/Java/jdk1.6.0_20/include/win32" wrimsv2_external_FunctionAnnLineGen.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared wrimsv2_external_FunctionAnnEC.o wrimsv2_external_FunctionAnnLineGen.o -o InterfaceToAnn.dll -L./ Ann7inp_CA.dll
copy InterfaceToAnn.dll ..\dll\InterfaceToAnn.dll
copy Ann7inp_CA.dll ..\dll\Ann7inp_CA.dll
del wrimsv2_external_FunctionAnnEC.o
del wrimsv2_external_FunctionAnnLineGen.o
del InterfaceToAnn.dll
del Ann7inp_CA.dll

