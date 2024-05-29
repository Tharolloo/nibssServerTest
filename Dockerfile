# Use a base image with Java and Maven pre-installed
FROM maven:3.8.4-openjdk-19 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image with Java pre-installed
FROM adoptopenjdk/openjdk19:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/nibssdemoproject.jar .

# Expose the port the application runs on
EXPOSE 8080

# Set the default command to run the application
CMD ["java", "-jar", "nibssservertest.jar"]



# FROM maven:3.8.7 as build

# COPY . .

# RUN mvn -B clean package -DskipTests

# FROM openjdk:17

# COPY --from=build target/*.jar nibbsservertest.jar

# #ENV SPRING_PROFILES_ACTIVE=${PROFILE}

# ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "nibbsservertest.jar"]
