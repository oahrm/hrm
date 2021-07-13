package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 考核评分表(PeExamineGrade)实体类
 *
 * @author makejava
 * @since 2021-07-13 09:56:55
 */
public class PeExamineGrade implements Serializable {
    private static final long serialVersionUID = 433863831480290601L;

    private String scoreId;

    private String performanceScoringObject;

    private Date scoreDate;

    private Integer gradingState;

    private String graderDepartment;

    private Integer assessmentScore;

    private String evaluate;

    private String empName;

    private String deptName;


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

    public Integer getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(Integer assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
