FROM openjdk:8-jdk-alpine

ARG JAR_FILE

ADD target/*.jar app.jar

ENV EUREKA_CLIENT_SERVICE="http://localhost:7001/eureka/";

ENTRYPOINT ["sh","-c","java -jar app.jar --spring.eureka.client.service-url.defaultZone=${EUREKA_CLIENT_SERVICE}"]