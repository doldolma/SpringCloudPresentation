FROM openjdk:17-ea-11-slim
VOLUME /tmp
COPY target/config-service-1.0.jar ConfigServer.jar
ENTRYPOINT ["java", "-jar", "ConfigServer.jar"]