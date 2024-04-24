# Use a Java runtime as the base image
FROM openjdk:21-slim-buster

VOLUME /tmp

# Copy the built JAR file into the container
ADD build/libs/gateway.jar gateway.jar

# Expose the default port for the app
EXPOSE 8888

# Start the app when the container launches
ENTRYPOINT ["java", "-jar", "gateway.jar"]
#ENTRYPOINT ["java", "-jar", "gateway.jar", "--spring.config.additional-location=file:/home/config/gateway-configuration.yml"]
