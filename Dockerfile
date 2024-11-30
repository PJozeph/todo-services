# Use a base image with Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Install Maven
RUN apk add --no-cache maven

# Build the project
RUN mvn clean package

# Copy the built JAR to the container
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
