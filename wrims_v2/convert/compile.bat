javac -cp "libs\\antlr-3.2.jar" antlr-generated\\wresl\\*.java
javac -cp "libs\\testng-5.14.1.jar;libs\\antlr-3.2.jar;antlr-generated" src\\test\\*.java

md bin

md bin\\wresl
copy antlr-generated\\wresl\\*.class bin\\wresl\\*.class
del  antlr-generated\\wresl\\*.class

md bin\\test
copy src\\test\\*.class bin\\test\\*.class
del  src\\test\\*.class

