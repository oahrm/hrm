package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * (EmpFamilyInfo)实体类
 *
 * @author makejava
 * @since 2021-07-13 03:21:13
 */
public class EmpFamilyInfo implements Serializable {
    private static final long serialVersionUID = 337189704515555285L;
    //id
    private String id;
    //员工id
    private String empId;
    //成员
    private String member;
    //工作单位
    private String workUnit;
    //职务
    private String post;
    //地址
    private String address;
    //手机号
    private String phone;


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

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
