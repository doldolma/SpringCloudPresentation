FROM openjdk:17-ea-11-slim
COPY target/apigateway-service-*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]