package com.hrm.oa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 入职通知多表字段
 */
@Data
public class RwruzhitonghiEntity {
    /**
     * 入职通知字段
     */

    private String id;//id

    private String title;//标题

    private String name;//姓名

    private String idcard;//身份证

    private String offerId;//外键

    private String postLine;//岗位条线

    private Integer entrystatus;//入职状态

    private Integer contractstatus;//合同签署状态

    private String jobResponsibilities;//岗位职责

    /**
     * offer字段
     */
    //private String offerId;链表查询

    private String offername;//offer名字

    // String name;//名字

    private String sex;//性别
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;//生日

    private String place;//籍贯

    private String phone;//手机

    //private String idcard;

    private String nation;//民族

    private String maritaStatus;//婚姻

    private String highestEducation;//最高学历

    private String academicDegree;//学位

    private String mailbox;//邮箱

    private Integer offerStatus;//offer状态

    private String division;//部门  丢弃不要

    private String directsuperior;//领导

    private String station;//岗位

    private String department;//部门

    private String officeLocation;//办公地点

    private Long basePay;//基础工资

    private Long meritPay;//绩效工资

    private Long regularSalary;//转正工资

    private Integer probationPeriod;//试用期

    private Long probationPeriodSalary;//试用期工资
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalTime;//到岗时间
}
