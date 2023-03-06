package com.cuprumz.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service()
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + ", this is SpringBoot test!!.";
    }
}
