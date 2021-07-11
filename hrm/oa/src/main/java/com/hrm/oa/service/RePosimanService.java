package com.hrm.oa.service;

import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.vo.OrganizationPageVo;

import java.util.Map;

public interface RePosimanService {

    public Map<String, Object> list(OrganizationPageVo organizationPageVo);

    public int save(RePosimanEntity rePosimanEntity);

    int delposi(RePosimanEntity rePosimanEntity);
}
