package com.hrm.oa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_dnewspaper
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrDnewspaper implements Serializable {
    private String dnId;

    private String pId;

    private String dnContent;

    private String dnStatus;

    private String dnEId;

    private static final long serialVersionUID = 1L;
}