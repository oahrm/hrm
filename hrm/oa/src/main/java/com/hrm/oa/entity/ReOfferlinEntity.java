package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * re_offer
 * @author 
 */
@Data
public class ReOfferlinEntity implements Serializable {
    private String offerId;

    private String offername;

    private String name;

    private String sex;

    private Date dateOfBirth;

    private String place;

    private String phone;

    private String idcard;

    private String nation;

    private String maritaStatus;

    private String highestEducation;

    private String academicDegree;

    private String mailbox;

    private Integer offerStatus;

    private String division;

    private String directsuperior;

    private String station;

    private String department;

    private String officeLocation;

    private Long basePay;

    private Long meritPay;

    private Long regularSalary;

    private Integer probationPeriod;

    private Long probationPeriodSalary;

    private Date arrivalTime;

    private static final long serialVersionUID = 1L;
}