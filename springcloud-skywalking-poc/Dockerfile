FROM apache/skywalking-base:8.0.1-es7 AS build

# 构建时环境变量，仅在构建镜像时有效
ARG DEFAULT_AGENT_SERVICE=192.168.1.122:11800
ARG DEFAULT_SERVICE_NAME=springcloud-sw-poc

# 运行时环境变量，仅在容器启动时有效
ENV SW_AGENT_SERVICE=$DEFAULT_AGENT_SERVICE
ENV SW_SERVICE_NAME=$DEFAULT_SERVICE_NAME

ADD target/*.jar app.jar

RUN ls

ENTRYPOINT ["sh","-c","java -javaagent:/skywalking/agent/skywalking-agent.jar -Dskywalking.agent\
.service_name=$SW_SERVICE_NAME -Dskywalking.collector.backend_service=$SW_AGENT_SERVICE -jar app.jar"]

# 查看容器的环境变量
#1. docker inspect <CONTAINER-NAME> OR <CONTAINER-ID>
#2. docker exec -it <CONTAINER-NAME> OR <CONTAINER-ID> env