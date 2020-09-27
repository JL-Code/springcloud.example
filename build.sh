mvn clean package -Dmaven.test.skip -pl springcloud-ribbon-order,springcloud-ribbon-order,springcloud-eureka -am
docker build -t mecode/order:1.0 springcloud-ribbon-order
docker build -t mecode/eureka:1.0 springcloud-eureka
docker build -t mecode/payment:1.0 springcloud-payment

# 192.168.1.81:7001
# http://192.168.1.81:8001/payment/100
# http://192.168.1.81:9001/payment/100

# mvn clean package -Dmaven.test.skip -pl springcloud-ribbon-order -am 
# --mount 挂载主机目录到容器（当主机目录不存在时 docker 报错）
# -v 挂载主机目录到容器（当主机目录不存在时 docker 自动创建）-v /Users/codeme/downloads/log:/var/log
# docker run -dp 9001:9001 --name order --mount type=bind,source=/Users/codeme/downloads/log,target=/var/log mecode/order:1.0 