set path=D:\Java\jdk_x86\jdk1.6.0_21\bin;%path%

javac -cp "libs\\antlr-3.2.jar" antlr-generated\\WRESL\\*.java
javac -cp "libs\\testng-5.14.1.jar;libs\\antlr-3.2.jar;antlr-generated" src\\test\\*.java

md bin

md bin\\WRESL
copy antlr-generated\\WRESL\\*.class bin\\WRESL\\*.class
del  antlr-generated\\WRESL\\*.class

md bin\\test
copy src\\test\\*.class bin\\test\\*.class
del  src\\test\\*.class

