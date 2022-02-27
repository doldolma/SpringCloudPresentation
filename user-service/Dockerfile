FROM openjdk:17-ea-11-slim
COPY target/user-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]