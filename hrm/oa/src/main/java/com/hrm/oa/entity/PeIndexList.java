package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * 指标列表(PeIndexList)实体类
 *
 * @author makejava
 * @since 2021-07-12 16:26:21
 */
public class PeIndexList implements Serializable {
    private static final long serialVersionUID = 370391307556947937L;

    private String indexId;

    private String nameOfIndex;

    private String indicatorDescription;

    private String type;

    private Object targetValue;

    private Object completeValue;

    private Object score;

    private Object goal;

    private Integer initiateMode;

    private String empId;

    private String inExplain;

    private String deptId;

    private String scoreId;

    private String pointerType;


    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
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

    public Object getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Object targetValue) {
        this.targetValue = targetValue;
    }

    public Object getCompleteValue() {
        return completeValue;
    }

    public void setCompleteValue(Object completeValue) {
        this.completeValue = completeValue;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public Object getGoal() {
        return goal;
    }

    public void setGoal(Object goal) {
        this.goal = goal;
    }

    public Integer getInitiateMode() {
        return initiateMode;
    }

    public void setInitiateMode(Integer initiateMode) {
        this.initiateMode = initiateMode;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getInExplain() {
        return inExplain;
    }

    public void setInExplain(String inExplain) {
        this.inExplain = inExplain;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getPointerType() {
        return pointerType;
    }

    public void setPointerType(String pointerType) {
        this.pointerType = pointerType;
    }

}
