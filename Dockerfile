FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/webtoeic-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java","-jar","/app/spring-app.jar"]
