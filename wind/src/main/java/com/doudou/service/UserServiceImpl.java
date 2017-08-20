package com.doudou.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.doudou.model.student.UserDto;
import com.doudou.mybatis.bean.UserDo;
import com.doudou.mybatis.bean.UserDoExample;
import com.doudou.mybatis.persistence.UserDoMapper;
import com.doudou.util.CommonContast;
import com.doudou.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenjiaming on 2017/8/20.
 */
@Service(version = CommonContast.SERVICE_VERSION)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userMapper;

    @Override
    public void insertUser(UserDto userDto) {
        Date date = new Date();
        userDto.setGmtModified(date);
        userDto.setGmtCreate(date);
        userMapper.insert(Convert.convertUser(userDto));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDo> list = userMapper.selectByExample(new UserDoExample());
        List<UserDto> result = new ArrayList<>(list.size());
        for (UserDo userDo : list) {
            result.add(Convert.convertUser(userDo));
        }
        return result;
    }

    @Override
    public UserDto login(String phone, String password) {
        UserDoExample example = new UserDoExample();
        UserDoExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andPasswordEqualTo(password);
        List<UserDo> list = userMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return Convert.convertUser(list.get(0));
        }
    }


}
