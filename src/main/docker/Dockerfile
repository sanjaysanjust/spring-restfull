FROM openjdk:8-jdk-alpine
EXPOSE 8085
#ARG JAR_FILE=spring-restfull-0.0.1-SNAPSHOT.jar
ADD spring-restfull-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
