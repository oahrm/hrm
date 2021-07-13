package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * (EmpAssets)实体类
 *
 * @author makejava
 * @since 2021-07-12 22:06:12
 */
public class EmpAssets implements Serializable {
    private static final long serialVersionUID = -86275070166139712L;

    private String id;

    private String empId;

    private String name;

    private String useDeptId;

    private String specification;

    private String assetGroup;

    private Integer status;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseDeptId() {
        return useDeptId;
    }

    public void setUseDeptId(String useDeptId) {
        this.useDeptId = useDeptId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getAssetGroup() {
        return assetGroup;
    }

    public void setAssetGroup(String assetGroup) {
        this.assetGroup = assetGroup;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
