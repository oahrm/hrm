package com.hrm.oa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_dservice
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrDservice implements Serializable {
    private String dsId;

    private String dnId;

    private String seId;

    private static final long serialVersionUID = 1L;
}