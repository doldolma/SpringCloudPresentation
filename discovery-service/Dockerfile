FROM openjdk:17-ea-11-slim
COPY target/discovery-service-*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]