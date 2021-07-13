package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * re_interview
 * @author 
 */
@Data
public class ReInterviewEntity implements Serializable {
    private String id;

    private String personInCharge;//面试负责人

    private String urgency;//紧急层度

    private String job;//岗位

    private Date applicationTime;//申请时间

    private Date scheduleInterviewDate;//面试时间

    private String interviewForm;//面试形式

    private String interviewStage;//面试阶段

    private String explains;//说明

    private String resumeId;//候选人简历

    public ReInterviewEntity(ReInterviewEntitytime reInterviewEntitytime) {
        this.personInCharge = reInterviewEntitytime.getPersonInCharge();
        this.urgency = reInterviewEntitytime.getUrgency();
        this.job = reInterviewEntitytime.getJob();
        this.interviewForm = reInterviewEntitytime.getInterviewForm();
        this.interviewStage = reInterviewEntitytime.getInterviewStage();
        this.explains = reInterviewEntitytime.getExplains();

    }

    public ReInterviewEntity() {

    }

    private static final long serialVersionUID = 1L;
}