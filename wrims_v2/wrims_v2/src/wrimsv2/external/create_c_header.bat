cd..
cd..
javac wrimsv2\external\ExternalFunction.java
javac -cp . wrimsv2\external\FunctionAnnEC.java
javah -jni wrimsv2.external.FunctionAnnEC
copy wrimsv2_external_FunctionAnnEC.h wrimsv2\cplusplus
del wrimsv2_external_FunctionAnnEC.h
del wrimsv2\external\ExternalFunction.class
del wrimsv2\external\FunctionAnnEC.class

