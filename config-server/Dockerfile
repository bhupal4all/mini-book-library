FROM openjdk:17-jdk-alpine

MAINTAINER "Ranga Bhupal"

# Copy the jar file to the container
COPY target/config-server-0.0.1-SNAPSHOT.jar /app/app.jar

VOLUME /app-configs

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:///app-configs

# Expose the port
EXPOSE 8888

# Execute the application
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.cloud.config.server.native.searchLocations=${SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS}"]
