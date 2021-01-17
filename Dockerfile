FROM openjdk:8-jdk-alpine
ADD application.jar application.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","application.jar"]
