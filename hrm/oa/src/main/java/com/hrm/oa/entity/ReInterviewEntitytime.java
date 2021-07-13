package com.hrm.oa.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * re_interview
 * @author 
 */
@Data
public class ReInterviewEntitytime implements Serializable {
    private String id;

    private String personInCharge;//面试负责人

    private String urgency;//紧急层度

    private String job;//岗位

    private String appTime;//申请时间

    private String scheDate;//面试时间

    private String interviewForm;//面试形式

    private String interviewStage;//面试阶段

    private String explains;//说明

    private String resumeId;//候选人简历

    private String name;//候选人

    private String sex;

    private String  birthday;

    private String nativeplace;

    private String phone;

    private String highesteducation;
    private String email;

    private static final long serialVersionUID = 1L;
}