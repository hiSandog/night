package com.doudou.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenjiaming on 2017/7/15.
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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