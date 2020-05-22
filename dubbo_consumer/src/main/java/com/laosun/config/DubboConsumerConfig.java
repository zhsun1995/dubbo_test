package com.laosun.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableDubbo(scanBasePackages = "com.laosun.service")
@ComponentScan(value = {"com.laosun.service"})
public class DubboConsumerConfig {
    @Bean
    // 应用配置
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("consumer");
        Map<String, String> map = new HashMap<String, String>();
        map.put("qos.enable", "true");
        map.put("qos.accept.foreign.ip", "false");
        map.put("qos.port", "33333");
        config.setParameters(map);
        return config;
    }

    @Bean
    // 消费者配置
    public ConsumerConfig consumerConfig() {
        ConsumerConfig config = new ConsumerConfig();
        config.setTimeout(5000);
        return config;
    }

    @Bean
    // 配置注册中心
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("127.0.0.1");
        config.setPort(2181);
        return config;
    }
}
