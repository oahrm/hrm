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
 * pr_project
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrProject implements Serializable {
    private String pId;

    private String pName;

    private String pType;

    private String pWorktype;

    private String pContract;

    private String pProgress;

    private String pProposal;

    private String pStatus;

    private String pFstatus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pStarttime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pEndtime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pBegain;

    private String pCustomer;

    private String pCphone;

    private String pEId;
    private Emp emp;

    private static final long serialVersionUID = 1L;
}