package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * emp
 * @author 
 */
@Data
public class Emp implements Serializable {
    //员工id
    private String empId;
    //手机号
    private String mobile;
    //密码
    private String password;
    //姓名
    private String name;
    //性别
    private String sex;
    //岗位
    private String post;
    //职级
    private Integer ranks;
    //部门id
    private String deptId;
    //部门名称
    @JsonProperty(value = "deptName")
    private String deptName;
    //在职状态（正式、实习）
    private Integer onTheJobStatus;
    //是否在线
    private Integer isItOnline;
    //上级id
    private String parentId;
    //工作描述
    private String jobDescription;
    //办公地点
    private String officeLocation;
    //紧急联系人
    private String emergencyContact;
    //紧急联系人电话
    private String emergencyContactNumber;
    //入职时间
    private Date entryTime;
    //离职时间
    private Date leavedate;
    //邮箱
    private String mailbox;

    private String sigerId;

    private static final long serialVersionUID = 1L;
}