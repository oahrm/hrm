package com.hrm.oa.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * cw_type
 * @author 
 */
@Data
public class CwType implements Serializable {
    private Integer typeId;

    private Integer typecc;

    private Integer typegc;

    private static final long serialVersionUID = 1L;
}