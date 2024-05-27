FROM openjdk:21

WORKDIR /app

COPY core/core-api/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]