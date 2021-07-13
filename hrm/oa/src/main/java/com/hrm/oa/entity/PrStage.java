package com.hrm.oa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_stage
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrStage implements Serializable {
    private String sId;

    private String sName;

    private String sDescription;

    private static final long serialVersionUID = 1L;
}