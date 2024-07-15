# Use an OpenJDK runtime as the base image
FROM openjdk:20

WORKDIR /app

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]