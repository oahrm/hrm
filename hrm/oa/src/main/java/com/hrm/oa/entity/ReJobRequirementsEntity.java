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
    private String jobId; //id

    private String jobName;//增补岗位名称

    private Integer demandNum;//需求人数

    private String applicant;//申请人

    private String applicationDept;//申请部门

    private Date applicationTime;//申请日期

    private String source;//用工来源

    private String reason;//增补理由

    private String natureOfWork;//工作性质

    private String jobResponsibilities;//岗位职责

    private String education;//学历

    private String workExperience;//工作经验

    private String placeOfWork;//工作地点

    private Integer lowerAgeLimit;//年龄下限

    private Integer upperAgeLimit;//年龄上限

    private BigDecimal salaryFloor;//薪资下限

    private BigDecimal salaryCap;//薪资上限

    private String major;//专业

    private Integer englishLevel;//英语等级

    private String other;//其他

    private Integer stats;//状态

    private static final long serialVersionUID = 1L;
}