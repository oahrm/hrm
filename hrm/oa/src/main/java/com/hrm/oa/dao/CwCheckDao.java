package com.hrm.oa.dao;

import com.hrm.oa.entity.CwCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CwCheckDao {
    int deleteByPrimaryKey(Integer checkId);

    int insertcheck(CwCheck cwCheck);

    int insertSelective(CwCheck record);

//    CwCheck selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(CwCheck record);

    int updateByPrimaryKey(CwCheck record);

    List<CwCheck>selectBycheck();
}