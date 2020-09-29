#!/bin/bash
echo "maven build..."
mvn clean package -Dmaven.test.skip -am
echo "docker build..."
docker build -t mecode/sw-poc:1.0.0-DEV .
#docker images mecode/sw-poc:1.0.0-DEV

##  docker inspect --format '{{.State.Running}}' <container_name> 查看指定容器名称的容器运行状态
echo "docker try stop rm ..."
containerName=mecode-sw-poc

cofstop=$(docker ps -a -f"Name=${containerName}" -q)
cofrunning=$(docker ps -f"Name=${containerName}" -q)

if [ "${cofrunning}" ];
then
  docker stop ${containerName}
fi

if [ "${cofstop}" ];
then
  docker rm ${containerName}
fi

echo "docker run ..."
containerId=$(docker run -dp 9090:8080 --name "${containerName}" -e SW_AGENT_SERVICE=192.168.1.122:11800 -e\
SW_SERVICE_NAME=mecode_sw_poc_$RANDOM mecode/sw-poc:1.0.0-DEV)

echo "$containerId"

docker logs --tail all "$containerId"

#docker exec -it "$containerId" /bin/sh