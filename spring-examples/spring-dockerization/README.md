```maven install``` to create the jar file      
``` docker build -t spring-dockerization .  ```          
```docker run -p 8080:8080 spring-dockerization  ```           
```docker run -p 8080:8080 -d spring-dockerization  ```      
add "-d" to run in background

###Dockerfile
FROM openjdk:17-jdk-alpine  
COPY target/*.jar spring-dockerization.jar  
ENTRYPOINT ["java","-jar","/spring-dockerization.jar"] 

###Dockerfile
FROM openjdk:17-oracle  
ARG JAR_FILE=target/*.jar  
COPY ${JAR_FILE} spring-dockerization.jar  
ENTRYPOINT ["java", "-jar", "/spring-dockerization.jar"]

###Dockerfile for apple m1  
FROM bellsoft/liberica-openjdk-alpine-musl:17  
COPY target/*.jar spring-dockerization.jar  
ENTRYPOINT ["java","-jar","/spring-dockerization.jar"]


```EXPOSE 8080``` to add a port   


##Another Example
```docker build -t spring-dockerization .  ```  
```docker run -p 8080:8080 spring-dockerization   ```  
```maven install``` not required

###Dockerfile

FROM openjdk:17 AS build

COPY pom.xml mvnw ./   
COPY .mvn .mvn   
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR spring-dockerization   
COPY --from=build target/*.jar spring-dockerization.jar   
ENTRYPOINT ["java", "-jar", "spring-dockerization.jar"]


