package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_task
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrTask implements Serializable {
    private String tId;

    private String sId;

    private String tName;

    private Integer tConstruction;

    private Integer tRconstruction;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tStarttime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tEndtime;

    private Double tProgress;

    private String tApproval;

    private String tEId;
    private Emp emp;

    private static final long serialVersionUID = 1L;
}