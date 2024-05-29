# FROM maven:3.8.7 as build

# COPY . .

# RUN mvn -B clean package -DskipTests

# FROM openjdk:17

# COPY --from=build target/*.jar nibbsservertest.jar

# #ENV SPRING_PROFILES_ACTIVE=${PROFILE}

# ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "nibbsservertest.jar"]


FROM maven:3.8.7 as build

COPY . .

RUN mvn -B clean package -DskipTests

FROM openjdk:17

COPY --from=build web/target/*.jar nibbsservertest.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "-Dspring.profiles.active=dev", "nibbsservertest.jar"]
