# PracticalSelenideAssignment
A new repository for hosting a first application created using the Selenide framework

This is a short README file created with the scope of explaining how to run the current application.

The current application has been created using the IntelliJ IDEA and Eclipse IDE environments and respectively the Maven build tool for
dependency management.

The structure of the current project includes only 3 files:
A) one test class called VodafoneTest.java - this is the place where the application source code is hosted; it has been created as
combination of the JUnit and the Selenide libraries;
B) one resource file called log4j.properties - this file is responsible for hosting the configuration required for using the Log4j and 
Slf4j frameworks needed in order to logout certain messages during the application run-time (in particular during the comparison tasks);
C) the pom.xml configuration file responsible for building and execution of the given project.
   
In order to setup the current project, the following steps will need to be executed:
1) Create a new Maven project from scratch inside IntelliJ IDEA/Eclipse IDE - follow the naming conventions listed inside the "pom.xml" 
file attached to this package in order to set up the group ID and the artifact ID for this project
2) In the newly created project, replace the content of the locally generated "pom.xml" file with that of the attached "pom.xml" and 
execute instruction "mvn clean install" from the command line for refreshing the project and downloading the newly inserted dependencies
3) Remove the Java classes generated as result of the Maven project creation phase from both the "src/main/java" and "src/test/java" 
locations (as they will not be required for the current project).
4) Copy and paste the source code file "VodafoneTest.java" into the relevant package (under location "src/test/java").
5) Copy and paste the resource file log4j.properties under location "src/main/resources" (create the folder "resources" manually in case
it is necessary).
6) Re-run again the instruction "mvn clean install" in the command line - this time the build procedure will trigger the execution of the
newly positioned test, as it is marked as a JUnit test.
7) After the execution of the given test, refresh the project folder (Eclipse IDE) / restart the IDE (for IntelliJ IDEA), locate and open 
the newly created file "testapp.log" - this will be responsible of registering the logs printed out during the given application.

NOTE:
In case it is possible, the current repository can also be cloned and integrated into the locally created new Maven-based Java project.
