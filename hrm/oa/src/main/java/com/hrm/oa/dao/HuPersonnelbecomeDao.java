package com.hrm.oa.dao;

import com.hrm.oa.entity.HuPersonnelbecome;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HuPersonnelbecomeDao {
    int deleteByPrimaryKey(String becomeId);

    int insert(HuPersonnelbecome record);

    int insertSelective(HuPersonnelbecome record);

    HuPersonnelbecome selectByPrimaryKey(String becomeId);

    int updateByPrimaryKeySelective(HuPersonnelbecome record);

    int updateByPrimaryKey(HuPersonnelbecome record);
}