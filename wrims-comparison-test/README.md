To execute the test model and generate a comparison report, run gradlew with a test task in this sub-project.
This can be done from this directory by launching gradlew in the parent directory, or by launching gradlew from
this directory with the following command:
```shell
../gradlew testReport
 
```

The testReport task will download a test watershed as a zip artifact from GitHub packages, and run WRIMS in 
build/testProjects/CalLite4.1_TR with run controls set in the file Test_01.config.

The report that the comparison tool produces is also stored as an artifact. The latest version can be found 
by following this link on the WRIMS project home page:  
![image](https://github.com/user-attachments/assets/7ad74689-67fc-4145-a788-4d8591597544)

The PDF of the report is the last item in the list *following* all the checksum values.  
![image](https://github.com/user-attachments/assets/d5c8ff59-5127-4249-a02a-287316677cc6)


The CalLite test model has been tested successfully running with Java 8 build 212. Newer versions of Java may
may not run the model successfully.
