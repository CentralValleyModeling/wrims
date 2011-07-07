javac -cp . wrimsv2\external\FunctionGetPumpShort.java
javah -jni wrimsv2.external.FunctionGetPumpShort
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionGetPumpShort.c
javac -cp . wrimsv2\external\FunctionGetStrm_H.java
javah -jni wrimsv2.external.FunctionGetStrm_H
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionGetStrm_H.c
javac -cp . wrimsv2\external\FunctionSimGW.java
javah -jni wrimsv2.external.FunctionSimGW
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionSimGW.c
javac -cp . wrimsv2\external\FunctionInitGWSystem.java
javah -jni wrimsv2.external.FunctionInitGWSystem
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionInitGWSystem.c
javac -cp . wrimsv2\external\FunctionSetDP.java
javah -jni wrimsv2.external.FunctionSetDP
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionSetDP.c
javac -cp . wrimsv2\external\FunctionGetPercentPumpShort.java
javah -jni wrimsv2.external.FunctionGetPercentPumpShort
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionGetPercentPumpShort.c
javac -cp . wrimsv2\external\FunctionSetStrmFlow.java
javah -jni wrimsv2.external.FunctionSetStrmFlow
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionSetStrmFlow.c
javac -cp . wrimsv2\external\FunctionGetGW_H.java
javah -jni wrimsv2.external.FunctionGetGW_H
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionGetGW_H.c
javac -cp . wrimsv2\external\FunctionGetSeep.java
javah -jni wrimsv2.external.FunctionGetSeep
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionGetSeep.c
javac -cp . wrimsv2\external\FunctionSetGP.java
javah -jni wrimsv2.external.FunctionSetGP
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_FunctionSetGP.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared wrimsv2_external_FunctionInitGWSystem.o wrimsv2_external_FunctionSetGP.o wrimsv2_external_FunctionSetDP.o wrimsv2_external_FunctionSetStrmFlow.o wrimsv2_external_FunctionSimGW.o wrimsv2_external_FunctionGetSeep.o wrimsv2_external_FunctionGetGW_H.o wrimsv2_external_FunctionGetStrm_H.o wrimsv2_external_FunctionGetPumpShort.o wrimsv2_external_FunctionGetPercentPumpShort.o -o interfacetogw.dll -L./ CVGroundwater.dll
