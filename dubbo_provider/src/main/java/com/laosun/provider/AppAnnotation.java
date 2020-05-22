package com.laosun.provider;

import com.laosun.config.DubboProviderConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AppAnnotation {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboProviderConfig.class);
        context.start();
        System.in.read();
    }
}
