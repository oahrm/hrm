package com.hrm.oa.vo;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class OrganizationPageVo implements Serializable {
    /**
     * 页尺寸
     */

    private Integer  pagesize;
    /**
     * 页码
     */
    private Integer  page;
}
