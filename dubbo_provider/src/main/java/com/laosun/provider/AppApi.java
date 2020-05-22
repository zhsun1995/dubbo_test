package com.laosun.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.laosun.service.ProviderService;
import com.laosun.service.impl.ProviderServiceImpl;

import java.io.IOException;

public class AppApi {
    public static void main(String[] args) throws IOException {

        // 生成服务端对象
        ProviderService providerService = new ProviderServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("provider");
        application.setOwner("laosun");

        // 连接注册中心
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);

        // ServiceConfig内部封装了与注册中心的连接，以及开启服务端口,实例很重，正式应用需要进行缓存
        // 服务者暴露服务配置
        ServiceConfig<ProviderService> service = new ServiceConfig<ProviderService>();
        service.setApplication(application);
        service.setRegistry(registry);
        service.setProtocol(protocol);
        service.setInterface(ProviderService.class);
        service.setRef(providerService);
        service.setVersion("1.0.0");

        // 暴露服务及注册
        service.export();

        System.in.read();

    }
}
