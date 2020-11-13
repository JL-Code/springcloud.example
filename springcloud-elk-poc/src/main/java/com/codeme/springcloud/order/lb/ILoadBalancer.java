package com.codeme.springcloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡规则接口
 */
public interface ILoadBalancer {
    /**
     * 选择服务
     * @param serviceInstanceList 所有的服务实例
     * @return
     */
    ServiceInstance choose(List<ServiceInstance> serviceInstanceList);
}
