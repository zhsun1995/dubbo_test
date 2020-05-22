package com.laosun.consumer;

import com.laosun.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main( String[] args ) throws IOException {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.sayHello("laosun");
        System.out.println(str);
        System.in.read();

    }
}
