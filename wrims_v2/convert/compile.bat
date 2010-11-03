javac -cp "libs\\antlr-3.2.jar" antlr-generated\\wresl\\*.java
javac -cp "libs\\testng-5.14.1.jar;libs\\antlr-3.2.jar;antlr-generated" src\\test\\convertWresl\\*.java

md bin

md bin\\wresl
copy antlr-generated\\wresl\\*.class bin\\wresl\\*.class
del  antlr-generated\\wresl\\*.class

md bin\\test
md bin\\test\\convertWresl
copy src\\test\\convertWresl\\*.class bin\\test\\convertWresl\\*.class
del  src\\test\\convertWresl\\*.class

