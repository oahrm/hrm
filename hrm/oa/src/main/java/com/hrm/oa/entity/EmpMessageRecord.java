package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmpMessageRecord)实体类
 *
 * @author makejava
 * @since 2021-07-12 15:20:13
 */
public class EmpMessageRecord implements Serializable {
    private static final long serialVersionUID = 326708422578749623L;

    private String id;

    private String message;

    private Integer status;

    private String sendId;

    private String takeId;

    private Date sendTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getTakeId() {
        return takeId;
    }

    public void setTakeId(String takeId) {
        this.takeId = takeId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

}
