package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.util.CommonContast;
import org.springframework.stereotype.Component;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Component
public class HelloWorldServiceImpl implements HelloWorldService {

    @Reference(version = CommonContast.SERVICE_VERSION)
    public HelloWorldService helloWorldService;

    @Override
    public String sayHelloWorld(String s) {
        return helloWorldService.sayHelloWorld(s);
    }

}