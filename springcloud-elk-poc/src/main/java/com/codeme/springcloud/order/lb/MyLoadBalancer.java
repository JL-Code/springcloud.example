package com.codeme.springcloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancer implements ILoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstanceList) {
        Integer index = incrementAndModulo(serviceInstanceList.size());
        return serviceInstanceList.get(index);
    }

    private int incrementAndModulo(int modulo) {

        for (; ; ) {
            int current = atomicInteger.get();
            int next = (current + 1) % modulo;
            if (atomicInteger.compareAndSet(current, next)) {
                System.out.println("===========current=====》" + current);
                System.out.println("===========next=====》" + next);
                return next;
            }
        }
    }
}
