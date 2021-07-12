package com.hrm.oa.dao;

import com.hrm.oa.entity.HuContractoflabor;

public interface HuContractoflaborDao {
    int deleteByPrimaryKey(String contractId);

    int insert(HuContractoflabor record);

    int insertSelective(HuContractoflabor record);

    HuContractoflabor selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(HuContractoflabor record);

    int updateByPrimaryKey(HuContractoflabor record);
}