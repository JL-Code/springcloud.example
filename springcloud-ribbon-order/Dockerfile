FROM centos:7.8.2003

RUN set -x \
    && yum update -y \
    && yum install -y java-1.8.0-openjdk iputils telnet curl  lsof net-tools iproute2

ARG JAR_FILE="springcloud-ribbon-order-latest.jar"

ADD target/${JAR_FILE} app.jar

ENV NACOS_CONFIG_SERVER_ADDR=192.168.3.67:8848

ENTRYPOINT ["sh","-c","java -jar app.jar --spring.cloud.nacos.config.server-addr=$NACOS_CONFIG_SERVER_ADDR"]