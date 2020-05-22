package com.laosun.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.laosun.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
