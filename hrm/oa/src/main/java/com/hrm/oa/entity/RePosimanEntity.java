package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * re_posiman
 * @author 
 */
@Data
public class RePosimanEntity implements Serializable {
    private String pmId;

    private Integer dId;

    private String job;

    private Integer organnum;

    private Integer actualnum;

    private Integer state;

    private String name;

    private Date time;

    private static final long serialVersionUID = 1L;
}