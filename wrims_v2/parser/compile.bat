javac -cp "libs\\antlr-3.2.jar" antlr-generated\\Parser\\*.java
javac -cp "libs\\testng-5.14.1.jar;libs\\antlr-3.2.jar;antlr-generated" src\\test\\*.java

md bin

md bin\\Parser
copy antlr-generated\\Parser\\*.class bin\\Parser\\*.class
del  antlr-generated\\Parser\\*.class

md bin\\test
copy src\\test\\*.class bin\\test\\*.class
del  src\\test\\*.class

