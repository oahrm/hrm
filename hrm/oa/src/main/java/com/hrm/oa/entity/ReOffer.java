package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * re_offer
 * @author 
 */
@Data
public class ReOffer implements Serializable {
    private String offerId;

    private String offername;

    private String name;

    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalTime;

    private static final long serialVersionUID = 1L;

    private ReEntryApplica re_entry_applica;
}