package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * (PeAssessmentResultsShow)实体类
 *
 * @author makejava
 * @since 2021-07-11 15:00:29
 */
public class PeAssessmentResultsShow implements Serializable {
    private static final long serialVersionUID = 283533252322588779L;

    private String resultId;

    private String sharingType;

    private String sharingPeople;

    private Integer sharingLevel;

    private String deptId;


    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getSharingType() {
        return sharingType;
    }

    public void setSharingType(String sharingType) {
        this.sharingType = sharingType;
    }

    public String getSharingPeople() {
        return sharingPeople;
    }

    public void setSharingPeople(String sharingPeople) {
        this.sharingPeople = sharingPeople;
    }

    public Integer getSharingLevel() {
        return sharingLevel;
    }

    public void setSharingLevel(Integer sharingLevel) {
        this.sharingLevel = sharingLevel;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

}
