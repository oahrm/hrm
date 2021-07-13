package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cw_field_personnel
 * @author 
 */
@Data
public class CwFieldPersonnel implements Serializable {
    private Integer fieldId;

    private Date fielddate;

    private String empname;

    private Integer kqtimeId;

    private Date fielddatetime;

    private String filedname;

    private String fieldadrss;

    private String fieldcustomer;

    private String filedremaeks;

    private Integer typeId;

    private static final long serialVersionUID = 1L;
}