To upload a CalSim or CalLite watershed for use in comparisons, run gradlew with a publish task in this sub-project.
This can be done from this directory by launching gradlew in the parent directory, or by launching gradlew from this directory with the following command:
```shell
../gradlew publish 
  -PsourceDir=<path to the CalSim or CalLite watershed>
  -PzipName=<name of the zip file to be created>
  -PpostVersion=<version of the zip file>
  -Pdwr-gpr.user=<username>
  -Pdwr-gpr.key=<password>
    
```

To execute the test model, run gradlew with a test task in this sub-project.
This can be done from this directory by launching gradlew in the parent directory, or by launching gradlew from this directory with the following command:
```shell
../gradlew testExec 
 
```

The testExec task will download a test watershed as a zip artifact from GitHub packages, and run WRIMS in build/testProjects/CalLite4.1_TR with run controls set in the file Test_01.config.
