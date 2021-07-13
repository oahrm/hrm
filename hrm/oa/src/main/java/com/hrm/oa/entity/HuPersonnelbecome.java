package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * hu_personnelbecome
 * @author 
 */
@Data
public class HuPersonnelbecome implements Serializable {
    private String becomeId;

    private String becomeName;

    private String becomeDept;

    private String becomeLeader;

    private Date entryStatus;

    private Date applyDate;

    private Integer applyState;

    private static final long serialVersionUID = 1L;
}