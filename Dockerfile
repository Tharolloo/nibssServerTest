FROM maven:3.8.7 as build

COPY . .

RUN mvn -B clean package -DskipTests

FROM openjdk:18

#COPY --from=build target/*.jar nibssdemoproject.jar


#ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "-Dspring.profiles.active=dev", "nisbsdemoproject.jar"]


# Use a base image with Java installed
#FROM adoptopenjdk:18-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container

COPY target/*.jar /app/nibbsDemoProject.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "nibbsDemoProject.jar"]

