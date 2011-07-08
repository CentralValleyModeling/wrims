javac -cp . wrimsv2\external\Functionannec_matchdsm2.java
javah -jni wrimsv2.external.Functionannec_matchdsm2
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionannec_matchdsm2.c
javac -cp . wrimsv2\external\Functionann_x2.java
javah -jni wrimsv2.external.Functionann_x2
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionann_x2.c
javac -cp . wrimsv2\external\Functiongetndo_x2_curmonndosplit.java
javah -jni wrimsv2.external.Functiongetndo_x2_curmonndosplit
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetndo_x2_curmonndosplit.c
javac -cp . wrimsv2\external\Functionannec.java
javah -jni wrimsv2.external.Functionannec
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionannec.c
javac -cp . wrimsv2\external\Functionannlinegen.java
javah -jni wrimsv2.external.Functionannlinegen
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionannlinegen.c
javac -cp . wrimsv2\external\Functiongetndo_x2.java
javah -jni wrimsv2.external.Functiongetndo_x2
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetndo_x2.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared wrimsv2_external_Functionannlinegen.o wrimsv2_external_Functionannec.o wrimsv2_external_Functionann_x2.o wrimsv2_external_Functiongetndo_x2_curmonndosplit.o wrimsv2_external_Functiongetndo_x2.o wrimsv2_external_Functionannec_matchdsm2.o -o interfacetoann.dll -L./ Ann7inp_CA.dll
