package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.annotation.Resource;

/**
 * hu_contractoflabor
 * @author 
 */
@Data
public class HuContractoflabor implements Serializable {
    @Resource
    private String contractId;

    private String deptName;

    private String signerName;

    private String signerPost;

    private String signerPhone;

    private Date signerTime;

    private Integer signerState;

    private Integer engageform;

    private String id;

    private static final long serialVersionUID = 1L;

    private ReEntryApplica re_entry_applica;
}