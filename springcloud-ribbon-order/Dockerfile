FROM openjdk:8-jdk-alpine

ARG JAR_FILE

ADD target/*.jar app.jar

ENV EUREKA_CLIENT_SERVICE="http://127.0.0.1:7001/eureka/";

ENTRYPOINT ["sh","-c","java -jar app.jar --eureka.client.service-url.defaultZone=${EUREKA_CLIENT_SERVICE}"]