# Use a base image with Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Maven build artifact
COPY target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Set the entry point
CMD ["java", "-jar", "app.jar"]
