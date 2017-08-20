package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doudou.model.student.UserDto;
import com.doudou.redis.UserRedis;
import com.doudou.util.CommonContast;
import com.doudou.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenjiaming on 2017/8/20.
 */
@Component
public class UserServiceImpl implements UserService {

    @Reference(version = CommonContast.SERVICE_VERSION)
    private UserService userService;

    @Autowired
    private UserRedis userRedis;

    @Override
    public void insertUser(UserDto userDto) {
        userService.insertUser(userDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDto login(String phone, String password) {
        UserDto userDto = userService.login(phone, password);
        if (userDto == null) {
            return null;
        } else {
            userRedis.setUser(getKey(phone, password), userDto);
            return userDto;
        }

    }

    private String getKey(String phone, String password) {
        String ss = phone + password;
        String key =  MD5Util.getMd5(1, ss);
        System.out.println(key);
        return key;
    }

}