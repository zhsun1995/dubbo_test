package com.laosun.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.laosun.service.ProviderService;
import com.laosun.service.impl.ProviderServiceImpl;

public class AppApi {
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
        application.setOwner("laosun");

        // 配置连接中心
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        // 引用远程服务
        ReferenceConfig<ProviderService> reference = new ReferenceConfig<ProviderService>(); //实例很重，需要进行缓存
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(ProviderService.class);

        // 使用服务端
        ProviderService providerService = new ProviderServiceImpl();
        String str = providerService.sayHello("laosun");
        System.out.println(str);
    }
}
