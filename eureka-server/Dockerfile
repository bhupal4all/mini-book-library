FROM openjdk:17-jdk-alpine

LABEL description="This is a Eureka Server"
LABEL author="Ranga Bhupal"
LABEL proeject="Microservices with Spring Boot"

# Copy the jar file to the container
COPY target/eureka-server-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port
EXPOSE 8761

# Execute the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
