package com.doudou.model;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class Student extends BaseModel {

    private String name;
    private int sex;
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

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}