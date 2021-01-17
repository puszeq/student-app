FROM openjdk:8-jdk-alpine
ADD runapp.jar runapp.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","runapp.jar"]
