package com.laosun.consumer;

import com.laosun.config.DubboConsumerConfig;
import com.laosun.service.ConsumerAnnotationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AppAnnotation {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConsumerConfig.class);
        context.start();
        ConsumerAnnotationService service = context.getBean(ConsumerAnnotationService.class);
        String str = service.sayHello("laosun");
        System.out.println(str);
        System.in.read();
    }
}
