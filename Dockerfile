FROM maven:3.8.6-openjdk-21-slim AS build

COPY --chown=maven:maven . /home/maven/src

WORKDIR /home/maven/src

RUN mvn clean package -DskipTests

# FROM openjdk:21-slim

# RUN mkdir /app

# COPY --from=build /home/maven/src/target/*.jar /app/server-0.0.1-SNAPSHOT.jar

# EXPOSE 8080

# ENTRYPOINT ["java","-jar","/app/server-0.0.1-SNAPSHOT.jar"]
