package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * re_resume
 * @author 
 */
@Data
public class ReResumeEntity implements Serializable {
    private String resumeId;

    private String name;

    private String sex;

    private Date birthday;

    private String nativePlace;

    private String placeOfAbode;

    private String politicsStatus;

    private String phone;

    private String email;

    private String educationExperience;

    private String honorsAndAwards;

    private String workExperience;

    private String professionalSkill;

    private String selfAssessment;

    private String highestEducation;

    private String appliedPosition;

    private String channel;

    private Integer expYear;

    public ReResumeEntity(ReInterviewEntitytime reInterviewEntitytime) {

        this.name = reInterviewEntitytime.getName();
        this.sex = reInterviewEntitytime.getSex();

        this.nativePlace = reInterviewEntitytime.getNativeplace();
        this.placeOfAbode = "";
        this.politicsStatus = "";
        this.phone = reInterviewEntitytime.getPhone();
        this.email = reInterviewEntitytime.getEmail();
        this.educationExperience = "";
        this.honorsAndAwards = "";
        this.workExperience = "";
        this.professionalSkill = "";
        this.selfAssessment = "";
        this.highestEducation = reInterviewEntitytime.getHighesteducation();
        this.appliedPosition = "";
        this.channel = "";
        this.expYear = 1;
    }

    private static final long serialVersionUID = 1L;
}