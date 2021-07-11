package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * (PeAssessmentSection)实体类
 *
 * @author makejava
 * @since 2021-07-11 15:15:50
 */
public class PeAssessmentSection implements Serializable {
    private static final long serialVersionUID = 298616181869773120L;

    private String scoreId;

    private String sectionName;

    private String startValueSymbol;

    private Integer initialValue;

    private String endValueSymbol;

    private Integer endValue;

    private Integer accordingOrder;

    private String deptId;


    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getStartValueSymbol() {
        return startValueSymbol;
    }

    public void setStartValueSymbol(String startValueSymbol) {
        this.startValueSymbol = startValueSymbol;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public String getEndValueSymbol() {
        return endValueSymbol;
    }

    public void setEndValueSymbol(String endValueSymbol) {
        this.endValueSymbol = endValueSymbol;
    }

    public Integer getEndValue() {
        return endValue;
    }

    public void setEndValue(Integer endValue) {
        this.endValue = endValue;
    }

    public Integer getAccordingOrder() {
        return accordingOrder;
    }

    public void setAccordingOrder(Integer accordingOrder) {
        this.accordingOrder = accordingOrder;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

}
