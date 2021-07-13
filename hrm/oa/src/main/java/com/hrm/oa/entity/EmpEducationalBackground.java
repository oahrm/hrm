package com.hrm.oa.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 学历背景表(EmpEducationalBackground)实体类
 *
 * @author makejava
 * @since 2021-07-13 14:14:01
 */
@Data
public class EmpEducationalBackground implements Serializable {
    private static final long serialVersionUID = 647507280990584921L;
    //id
    private String id;
    //员工id
    private String empId;
    //学校名称
    private String schoolName;
    //专业
    private String major;
    //开始时间
    private Date beginTime;
    //毕业时间
    private Date endTime;
    //描述
    private String describes;
    //学历
    private String education;
}
