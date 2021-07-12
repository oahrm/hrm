package com.hrm.oa.dao;

import com.hrm.oa.entity.PrService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrServiceDao {
    int deleteByPrimaryKey(String seId);

    int insert(PrService record);

    int insertSelective(PrService record);

    PrService selectByPrimaryKey(String seId);

    int updateByPrimaryKeySelective(PrService record);

    int updateByPrimaryKey(PrService record);
}