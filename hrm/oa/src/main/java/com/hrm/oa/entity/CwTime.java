package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cw_time
 * @author 
 */
@Data
public class CwTime implements Serializable {
    private Integer kqtimeId;

    private String morningTime;

    private String nightTime;

    private String nightsTime;

    private static final long serialVersionUID = 1L;
}