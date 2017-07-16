package com.doudou.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenjiaming on 2017/7/16.
 */
public class BaseMongoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Date gmtCreate;
    private Date gmtModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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