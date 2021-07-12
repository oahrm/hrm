package com.hrm.oa.dao;

import com.hrm.oa.entity.PrTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrTaskDao {
    int deleteByPrimaryKey(String tId);

    int insert(PrTask record);

    int insertSelective(PrTask record);

    PrTask selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(PrTask record);

    int updateByPrimaryKey(PrTask record);
}