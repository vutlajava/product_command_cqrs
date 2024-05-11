# Use the official OpenJDK image as base
FROM openjdk:11

MAINTAINER Ashok <vutlajava@gmail.com>

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/product_command_service_application.jar /usr/app/

# work directory
WORKDIR /usr/app

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "product_command_service-application.jar"]
