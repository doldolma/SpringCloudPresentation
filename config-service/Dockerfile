FROM openjdk:17-ea-11-slim
COPY target/config-service-1.0.jar app.jar
RUN apt-get update && apt-get install -y curl
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]