package com.doudou.model;

/**
 * Created by chenjiaming on 2017/7/9.
 */
public class StudentVo extends BaseDto {

    private String name;
    private Integer sex;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
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