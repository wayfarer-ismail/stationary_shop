# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add Maintainer Info
#LABEL maintainer="wayfarer-ismail"
#
## Add a volume pointing to /tmp
#VOLUME /tmp
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=target/stationary_shop-0.0.1-SNAPSHOT.jar
#
## Add the application's jar to the container
#ADD ${JAR_FILE} stationary_shop.jar
COPY target/stationary_shop-0.0.1-SNAPSHOT.jar /web.jar
# Run the jar file
ENTRYPOINT ["java","-jar","/web.jar"]
