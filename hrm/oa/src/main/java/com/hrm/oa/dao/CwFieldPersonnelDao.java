package com.hrm.oa.dao;

import com.hrm.oa.entity.CwFieldPersonnel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CwFieldPersonnelDao {
    int deleteByPrimaryKey(Integer fieldId);

    int insert(CwFieldPersonnel record);

    int insertSelective(CwFieldPersonnel record);

    CwFieldPersonnel selectByPrimaryKey(Integer fieldId);

    int updateByPrimaryKeySelective(CwFieldPersonnel record);

    int updateByPrimaryKey(CwFieldPersonnel record);
}