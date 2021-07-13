package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * 考核指标项表(PeAssessmentIndicators)实体类
 *
 * @author makejava
 * @since 2021-07-13 16:50:44
 */
public class PeAssessmentIndicators implements Serializable {
    private static final long serialVersionUID = 354671237632846502L;

    private String indexNumber;

    private String nameOfIndex;

    private String indicatorDescription;

    private String type;

    private Integer initiateMode;

    private String deptId;

    private Integer weight;


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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
