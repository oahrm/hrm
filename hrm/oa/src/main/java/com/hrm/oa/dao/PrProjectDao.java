package com.hrm.oa.dao;

import com.hrm.oa.entity.PrProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrProjectDao {
    int insertpr_project(PrProject record);//新增项目
//    int deleteByPrimaryKey(String pId);
//
//    int insert(PrProject record);
//
//    int insertSelective(PrProject record);
//
//    PrProject selectByPrimaryKey(String pId);
//
//    int updateByPrimaryKeySelective(PrProject record);
//
//    int updateByPrimaryKey(PrProject record);
}