FROM centos:7.8.2003

RUN set -x \
    && yum update -y \
    && yum install -y java-1.8.0-openjdk iputils telnet curl net-tools lsof iproute2

ARG JAR_FILE="springcloud-eureka-latest.jar"

ADD target/${JAR_FILE} app.jar

ENV EUREKA_DEFAULT_ZONE =""

ENTRYPOINT ["sh","-c","java -jar app.jar \
--eureka.instance.hostname=${HOSTNAME} --eureka.client.service-url.defaultZone=${EUREKA_DEFAULT_ZONE}"]