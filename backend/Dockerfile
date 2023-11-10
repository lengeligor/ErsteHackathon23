FROM openjdk:17-jdk-alpine

COPY /target/*.jar app.jar

#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java", "-Xmx3072m", "-jar", "./app.jar"]