package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmpWorkExperience)实体类
 *
 * @author makejava
 * @since 2021-07-13 11:51:32
 */
public class EmpWorkExperience implements Serializable {
    private static final long serialVersionUID = 559804091659395685L;

    private String id;

    //员工id
    private String empId;
    //公司名称
    private String coName;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //职务
    private String post;
    //描述
    private String miaoshu;
    //离职原因
    private String reasonsForLeaving;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getReasonsForLeaving() {
        return reasonsForLeaving;
    }

    public void setReasonsForLeaving(String reasonsForLeaving) {
        this.reasonsForLeaving = reasonsForLeaving;
    }

}
