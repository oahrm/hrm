package com.hrm.oa.dao;

import com.hrm.oa.entity.HuContractoflabor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HuContractoflaborDao {
    int deleteByPrimaryKey(String contractId);

    int insert(HuContractoflabor record);

    int insertSelective(HuContractoflabor record);

    HuContractoflabor selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(HuContractoflabor record);

    int updateByPrimaryKey(HuContractoflabor record);
}