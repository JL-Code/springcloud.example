FROM centos:7.8.2003

RUN set -x \
    && yum update -y \
    && yum install -y java-1.8.0-openjdk iputils telnet curl

ARG JAR_FILE="springcloud-payment-latest.jar"

ADD target/${JAR_FILE} app.jar

ENV EUREKA_DEFAULT_ZONE="http://127.0.0.1:7001/eureka/";

ENTRYPOINT ["sh","-c","java -jar app.jar --eureka.client.service-url.defaultZone=${EUREKA_DEFAULT_ZONE}"]