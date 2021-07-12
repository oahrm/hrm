package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PeExamineGrade)实体类
 *
 * @author makejava
 * @since 2021-07-11 16:23:59
 */
public class PeExamineGrade implements Serializable {
    private static final long serialVersionUID = -10839225677801349L;

    private String scoreId;

    private String performanceScoringObject;

    private Date scoreDate;

    private Integer gradingState;

    private String graderDepartment;

    private Object assessmentScore;

    private String evaluate;


    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getPerformanceScoringObject() {
        return performanceScoringObject;
    }

    public void setPerformanceScoringObject(String performanceScoringObject) {
        this.performanceScoringObject = performanceScoringObject;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public Integer getGradingState() {
        return gradingState;
    }

    public void setGradingState(Integer gradingState) {
        this.gradingState = gradingState;
    }

    public String getGraderDepartment() {
        return graderDepartment;
    }

    public void setGraderDepartment(String graderDepartment) {
        this.graderDepartment = graderDepartment;
    }

    public Object getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(Object assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

}
