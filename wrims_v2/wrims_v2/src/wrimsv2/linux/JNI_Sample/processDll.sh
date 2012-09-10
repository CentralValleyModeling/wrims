PATH=/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/bin:$PATH
export PATH
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functionannec_matchdsm2.java
javah -jni wrimsv2.external.Functionannec_matchdsm2
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functionannec_matchdsm2.c
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functionann_x2.java
javah -jni wrimsv2.external.Functionann_x2
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functionann_x2.c
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functiongetndo_x2_curmonndosplit.java
javah -jni wrimsv2.external.Functiongetndo_x2_curmonndosplit
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functiongetndo_x2_curmonndosplit.c
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functionannec.java
javah -jni wrimsv2.external.Functionannec
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functionannec.c
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functionannlinegen.java
javah -jni wrimsv2.external.Functionannlinegen
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functionannlinegen.c
javac -cp "/scratch/00359/hxie/wrimsv2_SG_64bit/lib64bit/WRIMSv2.jar" wrimsv2/external/Functiongetndo_x2.java
javah -jni wrimsv2.external.Functiongetndo_x2
gcc -c -fPIC -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include"  -I"/scratch/00359/hxie/wrimsv2_SG_64bit/jdk6/include/linux" wrimsv2_external_Functiongetndo_x2.c
gcc -Wall -D_JNI_IMPLEMENTATION_ -shared wrimsv2_external_Functionannlinegen.o wrimsv2_external_Functionannec.o wrimsv2_external_Functionann_x2.o wrimsv2_external_Functiongetndo_x2_curmonndosplit.o wrimsv2_external_Functiongetndo_x2.o wrimsv2_external_Functionannec_matchdsm2.o -o libinterfacetoann.so -L./ -lann7inp_ca
exit
