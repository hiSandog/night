package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Component
public class HelloWorldServiceImpl implements HelloWorldService {

    @Reference(version = "1.0.0")
    public HelloWorldService helloWorldService;

    @Override
    public String sayHelloWorld(String s) {
        return helloWorldService.sayHelloWorld(s);
    }

}