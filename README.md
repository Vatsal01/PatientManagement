### **Patient Management Test solution**

The application is intend to solve the problem proposed by CGI. The main objective is to prepare a patient management system which can manage the visits for the patients.
The project is based upon the following technologies:
- Java 11
- Springboot framework
- Gradle for build
- Postgres as Database
- Swagger as API level testing

Commands to run the project through intelliJ or basic console:

`./gradlew clean build`

As the project builds and resolves the dependencies.

`./gradlew bootRun`

This will run the project. The API will be accessible on configured port 9090 from application.properties.
The URL to access the API :

http://localhost:8080/

URL to access the swagger ui:

http://localhost:9090/swagger-ui/#/

All the endpoints are automatically deployed on swagger using SpringFox.

###### Pre-requisites:
- postgres is installed and running on system. The postgres properties can be modified in application.properties
- gradle is installed or using intelliJ which comes with default gradle plugin


###### Scope Remaining:
- add script to automate docker image generation
- enhance test cases coverage
- performance enhancements








