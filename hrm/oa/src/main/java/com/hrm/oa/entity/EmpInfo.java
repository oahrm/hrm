package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工个人信息表(EmpInfo)实体类
 *
 * @author makejava
 * @since 2021-07-13 00:43:46
 */
public class EmpInfo implements Serializable {
    private static final long serialVersionUID = 417147608451130161L;

    private String empId;
    //出生日期
    private Date dateOfBirth;
    //籍贯
    private String nativePlace;
    //民族
    private String nation;
    //身份证
    private String idCard;
    //政治面貌
    private String politicalOutlook;
    //入党日期
    private Date dateOfJoiningTheParty;
    //学历
    private String education;
    //学位
    private String academicDegree;
    //现住地
    private String currentResidence;


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public Date getDateOfJoiningTheParty() {
        return dateOfJoiningTheParty;
    }

    public void setDateOfJoiningTheParty(Date dateOfJoiningTheParty) {
        this.dateOfJoiningTheParty = dateOfJoiningTheParty;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getCurrentResidence() {
        return currentResidence;
    }

    public void setCurrentResidence(String currentResidence) {
        this.currentResidence = currentResidence;
    }

}
