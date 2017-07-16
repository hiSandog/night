package com.doudou.model;



import org.springframework.data.annotation.Reference;

import java.util.Date;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class BaseMongoRepo {

    private Date gmtCreate;
    private Date gmtModified;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}