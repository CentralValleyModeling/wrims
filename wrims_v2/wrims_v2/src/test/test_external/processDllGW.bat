javac -cp . wrimsv2\external\Functiongetpumpshort.java
javah -jni wrimsv2.external.Functiongetpumpshort
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetpumpshort.c
javac -cp . wrimsv2\external\Functionsetdp.java
javah -jni wrimsv2.external.Functionsetdp
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionsetdp.c
javac -cp . wrimsv2\external\Functionsimgw.java
javah -jni wrimsv2.external.Functionsimgw
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionsimgw.c
javac -cp . wrimsv2\external\Functioninitgwsystem.java
javah -jni wrimsv2.external.Functioninitgwsystem
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functioninitgwsystem.c
javac -cp . wrimsv2\external\Functiongetpercentpumpshort.java
javah -jni wrimsv2.external.Functiongetpercentpumpshort
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetpercentpumpshort.c
javac -cp . wrimsv2\external\Functionprintgwresults.java
javah -jni wrimsv2.external.Functionprintgwresults
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionprintgwresults.c
javac -cp . wrimsv2\external\Functiongetgw_h.java
javah -jni wrimsv2.external.Functiongetgw_h
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetgw_h.c
javac -cp . wrimsv2\external\Functiongetseep.java
javah -jni wrimsv2.external.Functiongetseep
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetseep.c
javac -cp . wrimsv2\external\Functionadvancegwstate.java
javah -jni wrimsv2.external.Functionadvancegwstate
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionadvancegwstate.c
javac -cp . wrimsv2\external\Functiongetstrm_h.java
javah -jni wrimsv2.external.Functiongetstrm_h
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functiongetstrm_h.c
javac -cp . wrimsv2\external\Functionsetstrmflow.java
javah -jni wrimsv2.external.Functionsetstrmflow
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionsetstrmflow.c
javac -cp . wrimsv2\external\Functionsetgp.java
javah -jni wrimsv2.external.Functionsetgp
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -c -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include"  -I"C:/Program Files (x86)/Java/jdk1.6.0_24/include/win32" wrimsv2_external_Functionsetgp.c
D:/cvwrsm/trunk/3rd_party/MinGW/bin/gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -shared wrimsv2_external_Functioninitgwsystem.o wrimsv2_external_Functionsetgp.o wrimsv2_external_Functionsetdp.o wrimsv2_external_Functionsetstrmflow.o wrimsv2_external_Functionsimgw.o wrimsv2_external_Functiongetseep.o wrimsv2_external_Functiongetgw_h.o wrimsv2_external_Functiongetstrm_h.o wrimsv2_external_Functiongetpumpshort.o wrimsv2_external_Functiongetpercentpumpshort.o wrimsv2_external_Functionprintgwresults.o wrimsv2_external_Functionadvancegwstate.o -o interfacetogw.dll -L./ CVGroundwater.dll
