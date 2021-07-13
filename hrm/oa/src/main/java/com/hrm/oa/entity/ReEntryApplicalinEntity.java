package com.hrm.oa.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * re_entry_applica
 * @author 
 */
@Data
public class ReEntryApplicalinEntity implements Serializable {
    private String id;

    private String title;

    private String name;

    private String idcard;

    private String offerId;

    private String postLine;

    private Integer entrystatus;

    private Integer contractstatus;

    private String jobResponsibilities;

    private static final long serialVersionUID = 1L;
}