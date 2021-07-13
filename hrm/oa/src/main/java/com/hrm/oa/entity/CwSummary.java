package com.hrm.oa.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * cw_summary
 * @author 
 */
@Data
public class CwSummary implements Serializable {
    private Integer summaryId;

    private Integer kqtimeId;

    private String empname;

    private Integer number;

    private Integer id;

    private Integer fieldId;

    private Integer checkId;

    private Integer typeId;

    private static final long serialVersionUID = 1L;
}