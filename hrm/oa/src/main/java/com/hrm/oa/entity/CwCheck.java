package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * cw_check
 * @author 
 */
@Data
public class CwCheck implements Serializable {
    private Integer checkId;

    private Integer kqtimeId;

    private String empname;

    private String deptname;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date checkdata;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm:ss")
    private Date checkdatatime;

    private String typezt;

    private String typecd;

    private Integer typekg;

    private Integer typeyzzt;

    private Integer typeyzcd;

    private Integer typesj;

    private Integer typebj;

    private Integer typenj;

    private Integer typetx;

    private String typelq;

    private Integer fieldId;

    private static final long serialVersionUID = 1L;
}