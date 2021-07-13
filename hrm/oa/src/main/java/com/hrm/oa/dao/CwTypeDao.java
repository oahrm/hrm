package com.hrm.oa.dao;

import com.hrm.oa.entity.CwType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CwTypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(CwType record);

    int insertSelective(CwType record);

//    CwType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(CwType record);

    int updateBytype(CwType record);

    List<CwType>selectBytype();
}