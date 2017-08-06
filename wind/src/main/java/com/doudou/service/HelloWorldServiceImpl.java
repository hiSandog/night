package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.util.CommonContast;

/**
 * Created by chenjiaming on 2017/7/16.
 */
@Service(version = CommonContast.SERVICE_VERSION)
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHelloWorld(String s) {
        return "Hello World :" + s;
    }

}