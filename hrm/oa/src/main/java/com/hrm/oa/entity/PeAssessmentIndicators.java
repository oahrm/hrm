package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * 考核指标项表(PeAssessmentIndicators)实体类
 *
 * @author makejava
 * @since 2021-07-12 18:48:33
 */
public class PeAssessmentIndicators implements Serializable {
    private static final long serialVersionUID = 374679298336012817L;

    private String indexNumber;

    private String nameOfIndex;

    private String indicatorDescription;

    private String type;

    private Integer initiateMode;

    private String deptId;


    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getNameOfIndex() {
        return nameOfIndex;
    }

    public void setNameOfIndex(String nameOfIndex) {
        this.nameOfIndex = nameOfIndex;
    }

    public String getIndicatorDescription() {
        return indicatorDescription;
    }

    public void setIndicatorDescription(String indicatorDescription) {
        this.indicatorDescription = indicatorDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInitiateMode() {
        return initiateMode;
    }

    public void setInitiateMode(Integer initiateMode) {
        this.initiateMode = initiateMode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

}
