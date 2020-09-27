mvn clean package -Dmaven.test.skip -pl springcloud-ribbon-order -am
java -jar springcloud-ribbon-order/target/springcloud-ribbon-order-1.0.0-SNAPSHOT.jar \
-javaagent:/Users/codeme/Downloads/agent/skywalking-agent.jar=agent.service_name=ribbon-order-service,\
collector.backend_service=192.168.1.9:11800