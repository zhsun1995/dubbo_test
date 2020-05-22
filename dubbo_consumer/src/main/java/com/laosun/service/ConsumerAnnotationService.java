package com.laosun.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerAnnotationService {
    @Reference
    private ProviderService providerService;

    public String sayHello(String name) {
        return providerService.sayHello(name);
    }
}
