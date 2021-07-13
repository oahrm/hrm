package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * 指标列表(PeIndexList)实体类
 *
 * @author makejava
 * @since 2021-07-13 16:50:25
 */
public class PeIndexList implements Serializable {
    private static final long serialVersionUID = -24169759883155511L;

    private String indexId;

    private String nameOfIndex;

    private String indicatorDescription;

    private String type;

    private Integer targetValue;

    private Integer completeValue;

    private Integer score;

    private Integer goal;

    private Integer initiateMode;

    private String empId;

    private String inExplain;

    private String deptId;

    private String scoreId;

    private String pointerType;

    private Integer weight;


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

    public Integer getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }

    public Integer getCompleteValue() {
        return completeValue;
    }

    public void setCompleteValue(Integer completeValue) {
        this.completeValue = completeValue;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
