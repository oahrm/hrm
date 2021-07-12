package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PeDepartment)实体类
 *
 * @author makejava
 * @since 2021-07-11 21:02:08
 */
public class PeDepartment implements Serializable {
    private static final long serialVersionUID = 495714042113639308L;

    private String deptId;

    private String name;

    private String code;

    private String managerName;

    private String managerId;

    private Date createTime;

    private String introduce;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
