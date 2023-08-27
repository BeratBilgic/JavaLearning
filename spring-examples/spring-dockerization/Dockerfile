FROM bellsoft/liberica-openjdk-alpine-musl:17
COPY target/*.jar spring-dockerization.jar
ENTRYPOINT ["java","-jar","/spring-dockerization.jar"]