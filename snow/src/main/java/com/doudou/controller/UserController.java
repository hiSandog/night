package com.doudou.controller;

import com.doudou.core.SnowException;
import com.doudou.model.CommonResponse;
import com.doudou.model.UserVo;
import com.doudou.model.request.LoginRequest;
import com.doudou.model.request.UserInsertRequest;
import com.doudou.model.student.UserDto;
import com.doudou.service.UserServiceImpl;
import com.doudou.util.Convert;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjiaming on 2017/8/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("获取所有用户的接口")
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAll() throws SnowException {
        List<UserDto> list = userService.getAllUsers();
        List<UserVo> result = new ArrayList<>(list.size());
        for (UserDto userDto : list) {
            result.add(Convert.convertUser(userDto));
        }
        return new ResponseEntity<>(new CommonResponse(result), HttpStatus.OK);
    }

    @ApiOperation("插入一条用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="insertRequest", value="傅红雪,13774486042,0", dataType = "UserInsertRequest")
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> insert (@RequestBody UserInsertRequest insertRequest) throws SnowException {
        try {
            userService.insertUser(Convert.convertUser(insertRequest.getUser()));
        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponse(300, "该手机号已经注册过"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="phone", defaultValue="13774486042",value="手机号", paramType="query", required = true, dataType = "string"),
            @ApiImplicitParam(name="password", defaultValue="123456",value="密码", paramType="query", required = true, dataType = "string")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> login (@ModelAttribute LoginRequest loginRequest) throws SnowException {
        UserDto userDto = userService.login(loginRequest.getPhone(), loginRequest.getPassword());
        if (userDto == null) {
            return new ResponseEntity<>(new CommonResponse(300, "无此用户或密码错误"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CommonResponse(userDto), HttpStatus.OK);
        }
    }

}