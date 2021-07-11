package com.hrm.oa.entity;

import java.io.Serializable;

/**
 * 考核设置表(PeAssessmentSetting)实体类
 *
 * @author makejava
 * @since 2021-07-12 00:53:00
 */
public class PeAssessmentSetting implements Serializable {
    private static final long serialVersionUID = 825295103077841198L;

    private String assSettingId;

    private String programMaker;

    private String programApprover;

    private String scoreConfirmer;

    private Integer scoreRangeMin;

    private Integer scoreRangeMax;

    private String deptId;


    public String getAssSettingId() {
        return assSettingId;
    }

    public void setAssSettingId(String assSettingId) {
        this.assSettingId = assSettingId;
    }

    public String getProgramMaker() {
        return programMaker;
    }

    public void setProgramMaker(String programMaker) {
        this.programMaker = programMaker;
    }

    public String getProgramApprover() {
        return programApprover;
    }

    public void setProgramApprover(String programApprover) {
        this.programApprover = programApprover;
    }

    public String getScoreConfirmer() {
        return scoreConfirmer;
    }

    public void setScoreConfirmer(String scoreConfirmer) {
        this.scoreConfirmer = scoreConfirmer;
    }

    public Integer getScoreRangeMin() {
        return scoreRangeMin;
    }

    public void setScoreRangeMin(Integer scoreRangeMin) {
        this.scoreRangeMin = scoreRangeMin;
    }

    public Integer getScoreRangeMax() {
        return scoreRangeMax;
    }

    public void setScoreRangeMax(Integer scoreRangeMax) {
        this.scoreRangeMax = scoreRangeMax;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

}
