FROM openjdk:17-jdk-slim

MAINTAINER "Ranga Bhupal"

# Copy the jar file to the container
COPY target/inventory-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port
EXPOSE 8080

# Execute the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
