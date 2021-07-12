package com.hrm.oa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_detailproject
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrDetailproject implements Serializable {
    private String dId;

    private String tId;
    private PrTask prTask;

    private String pId;
    private PrProject prProject;

    private static final long serialVersionUID = 1L;
}