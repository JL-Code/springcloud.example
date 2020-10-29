FROM openjdk:8-jdk-alpine

ARG JAR_FILE

ADD target/springcloud-eureka-latest.jar app.jar

ENTRYPOINT ["sh","-c","java -jar app.jar \
--eureka.instance.hostname=${HOSTNAME}"]