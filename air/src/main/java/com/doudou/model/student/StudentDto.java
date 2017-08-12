package com.doudou.model.student;

import com.doudou.model.BaseDto;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class StudentDto extends BaseDto {

    private String name;

    // 0 Î´È·ÈÏ 1 ÄÐ 2 Å®
    private Integer sex;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}