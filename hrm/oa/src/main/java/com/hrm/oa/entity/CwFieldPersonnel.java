package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * cw_field_personnel
 * @author 
 */
@Data
public class CwFieldPersonnel implements Serializable {
    private Integer fieldId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date fielddate;

    private String empname;

    private Integer kqtimeId;

    @JsonFormat(timezone = "GMT+8",pattern = "HH:mm:ss")
    private Date fielddatetime;

    private String filedname;

    private String fieldadrss;

    private String fieldcustomer;

    private String filedremaeks;

    private Integer typeId;

    private static final long serialVersionUID = 1L;
}