package com.cuprumz;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cuprumz.controller.HelloController;
import com.cuprumz.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo
public class ConsumerApp {


    public static void main(String[] args) {
//        SpringApplication.run(ConsumerApp.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApp.class, args);
        HelloController controller = context.getBean(HelloController.class);
        String result = controller.sayHello("world");
        System.out.println("result: " + result);
        
    }
}
