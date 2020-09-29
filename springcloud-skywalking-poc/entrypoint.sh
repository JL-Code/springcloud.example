#!/bin/sh
echo "$SERVICE_NAME"
echo "$SW_AGENT_SERVICE"
java -javaagent:/usr/skywalking/agent/skywalking-agent.jar -Dskywalking.agent.service_name="$SERVICE_NAME" -Dskywalking
.collector.backend_service="$SW_AGENT_SERVICE" -jar springcloud-skywalking-poc-1.0.0-SNAPSHOT.jar