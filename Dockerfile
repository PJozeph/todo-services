# Use a base image with Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app
COPY pom.xml .
COPY src ./src

# install maven
RUN apk add maven

# build the project
RUN mvn clean package


# Copy the todo-0.0.1-SNAPSHOT.jar file to the container
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# # Run the jar file
CMD ["java", "-jar", "app.jar"]