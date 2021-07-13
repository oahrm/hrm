package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * hu_personnelentry
 * @author 
 */
@Data
public class HuPersonnelentry implements Serializable {
    private String personnelentryId;

    private Date entryTime;

    private Integer personnelSex;

    private String personnelPhone;

    private String personnelName;

    private Date sigerTime;

    private Integer entryStatus;

    private Integer engageform;

    private String deptId;

    private static final long serialVersionUID = 1L;
}