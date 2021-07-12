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
    private String pmId;//编号

    private Integer dId;//部门

    private String job;//职务名称

    private Integer organnum;//编制人数

    private Integer actualnum;//实际人数

    private Integer state;//状态

    private String name;//新建人

    private Date time;//新建时间

    private static final long serialVersionUID = 1L;
}