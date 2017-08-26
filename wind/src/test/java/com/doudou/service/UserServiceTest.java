package com.doudou.service;

import com.doudou.model.student.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chenjiaming on 2017/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser(){
        UserDto userDto = new UserDto();
        userDto.setName("令狐冲");
        userDto.setPhone("13898345687");
        userDto.setPassword("123456");
        userService.insertUser(userDto);
    }

    @Test
    public void getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        for (UserDto userDto : userDtos) {
            System.out.println(userDto.getName());
            System.out.println(userDto.getPassword());
            System.out.println(userDto.getPhone());
        }
    }

    @Test
    public void login(){
        UserDto userDto = userService.login("13774486042", "123456");
        if (userDto != null) {
            System.out.println(userDto.getId());
        }
    }

}