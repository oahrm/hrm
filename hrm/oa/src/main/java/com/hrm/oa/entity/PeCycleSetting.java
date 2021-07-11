package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PeCycleSetting)实体类
 *
 * @author makejava
 * @since 2021-07-11 16:44:05
 */
public class PeCycleSetting implements Serializable {
    private static final long serialVersionUID = 590073267479806367L;

    private String cycleSettingNumber;

    private String type;

    private Date createTime;

    private Date deadline;

    private Date ceadlineForApproval;


    public String getCycleSettingNumber() {
        return cycleSettingNumber;
    }

    public void setCycleSettingNumber(String cycleSettingNumber) {
        this.cycleSettingNumber = cycleSettingNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCeadlineForApproval() {
        return ceadlineForApproval;
    }

    public void setCeadlineForApproval(Date ceadlineForApproval) {
        this.ceadlineForApproval = ceadlineForApproval;
    }

}
