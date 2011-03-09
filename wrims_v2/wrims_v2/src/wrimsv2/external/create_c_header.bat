cd..
cd..
javac wrimsv2\external\ExternalFunction.java
javac -cp . wrimsv2\external\FunctionAnnEC.java
javac -cp . wrimsv2\external\FunctionAnnLineGen.java
javah -jni wrimsv2.external.FunctionAnnEC
javah -jni wrimsv2.external.FunctionAnnLineGen
copy wrimsv2_external_FunctionAnnEC.h wrimsv2\cplusplus
copy wrimsv2_external_FunctionAnnLineGen.h wrimsv2\cplusplus
del wrimsv2_external_FunctionAnnEC.h
del wrimsv2_external_FunctionAnnLineGen.h
del wrimsv2\external\ExternalFunction.class
del wrimsv2\external\FunctionAnnEC.class
del wrimsv2\external\FunctionAnnLineGen.class

