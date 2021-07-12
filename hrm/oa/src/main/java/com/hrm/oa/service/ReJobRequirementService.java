package com.hrm.oa.service;

import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.vo.PageVo;

import java.util.Map;

public interface ReJobRequirementService {
    /**
     * 初始化列表
     * @param pageVo
     * @return
     */
    public Map<String, Object> list(PageVo pageVo);

    public int save(ReJobRequirementsEntity reJobRequirementsEntity);

    int delposi(ReJobRequirementsEntity reJobRequirementsEntity);

    /**
     * 修改
     * @param reJobRequirementsEntity
     */
    int modifyjob(ReJobRequirementsEntity reJobRequirementsEntity);
}
