package com.hrm.oa.dao;

import com.hrm.oa.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {
    int deleteByPrimaryKey(String id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}