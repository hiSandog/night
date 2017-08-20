package com.doudou.model.student;

import com.doudou.model.BaseDto;

/**
 * Created by chenjiaming on 2017/8/20.
 */
public class UserDto extends BaseDto {

    private String name;
    private String phone;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}