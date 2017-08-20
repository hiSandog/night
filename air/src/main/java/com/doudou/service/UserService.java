package com.doudou.service;

import com.doudou.model.student.UserDto;

import java.util.List;

/**
 * Created by chenjiaming on 2017/8/20.
 */
public interface UserService {

    void insertUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto login(String phone, String password);

}