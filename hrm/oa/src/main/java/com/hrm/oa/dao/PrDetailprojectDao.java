package com.hrm.oa.dao;

import com.hrm.oa.entity.PrDetailproject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrDetailprojectDao {
    int insertpr_detailproject(PrDetailproject record);//新增项目详细
//    int deleteByPrimaryKey(String dId);
//
//    int insert(PrDetailproject record);
//
//    int insertSelective(PrDetailproject record);
//
//    PrDetailproject selectByPrimaryKey(String dId);
//
//    int updateByPrimaryKeySelective(PrDetailproject record);
//
//    int updateByPrimaryKey(PrDetailproject record);
}