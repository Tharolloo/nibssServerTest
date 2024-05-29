FROM maven:3.8.7 as build

COPY . .

RUN mvn -B clean package -DskipTests

FROM openjdk:18

#COPY --from=build target/*.jar nibssdemoproject.jar
COPY nibssDemoProject.jar nibssDemoProject.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "-Dspring.profiles.active=dev", "nibssdemoproject.jar"]

