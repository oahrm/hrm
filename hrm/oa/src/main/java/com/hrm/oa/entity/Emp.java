package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * emp
 * @author 
 */
@Data
public class Emp implements Serializable {
    private String id;

    private String mobile;

    private String password;

    private String name;

    private String sex;

    private String post;

    private Integer ranks;

    private String deptId;

    private Integer onTheJobStatus;

    private Integer isItOnline;

    private String parentId;

    private String jobDescription;

    private String officeLocation;

    private String emergencyContact;

    private String emergencyContactNumber;

    private Date entryTime;

    private Date leavedate;

    private String mailbox;

    private String sigerId;

    private static final long serialVersionUID = 1L;
}