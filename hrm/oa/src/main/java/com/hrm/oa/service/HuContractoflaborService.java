package com.hrm.oa.service;

import com.hrm.oa.entity.HuContractoflabor;

public interface HuContractoflaborService {
    //新增
    HuContractoflabor insertHuContractoflabor(HuContractoflabor huContractoflabor);
    /**
     * 查询员工合同
     */
    HuContractoflabor findContractoflaborById(String contractId);
}
