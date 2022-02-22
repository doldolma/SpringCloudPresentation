FROM openjdk:17-ea-11-slim
COPY target/config-service-1.0.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]