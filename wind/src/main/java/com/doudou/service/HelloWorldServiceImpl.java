package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Service(version = "1.0.0")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHelloWorld(String s) {
        return "Hello World :" + s;
    }

}