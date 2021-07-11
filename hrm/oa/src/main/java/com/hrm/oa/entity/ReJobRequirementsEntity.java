package com.hrm.oa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * re_job_requirements
 * @author 
 */
@Data
public class ReJobRequirementsEntity implements Serializable {
    private String jobId;

    private String jobName;

    private Integer demandNum;

    private String applicant;

    private String applicationDept;

    private Date applicationTime;

    private String source;

    private String reason;

    private String natureOfWork;

    private String jobResponsibilities;

    private String education;

    private String workExperience;

    private String placeOfWork;

    private Integer lowerAgeLimit;

    private Integer upperAgeLimit;

    private BigDecimal salaryFloor;

    private BigDecimal salaryCap;

    private String major;

    private Integer englishLevel;

    private String other;

    private Integer stats;

    private static final long serialVersionUID = 1L;
}