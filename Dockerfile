FROM maven:3.8.7 as build

COPY . .

RUN mvn -B clean package -DskipTests

FROM openjdk:18

COPY --from=build target/*.jar nibbsdemoproject.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "-Dspring.profiles.active=dev", "nibbsDemoProject.jar"]
