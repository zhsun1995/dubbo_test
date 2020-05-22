package com.laosun.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDubbo(scanBasePackages = "com.laosun.service")
public class DubboProviderConfig {
    @Bean
    // 服务端信息配置
    public ProviderConfig providerConfig() {
        ProviderConfig config = new ProviderConfig();
        config.setTimeout(1000);
        return config;
    }

    @Bean
    // 分布式应用信息配置
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("provider");
        return config;
    }

    @Bean
    // 注册中心信息配置
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("127.0.0.1");
        config.setPort(2181);
        return config;
    }

    @Bean
    // 使用dubbo协议配置
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20881);
        return  config;
    }
}
