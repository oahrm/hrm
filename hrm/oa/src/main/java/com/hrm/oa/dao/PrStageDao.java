package com.hrm.oa.dao;

import com.hrm.oa.entity.PrStage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrStageDao {
    int insertpr_stage(PrStage record);//新增项目阶段

    List<PrStage> selectAllpr_stage();//查询所有项目阶段

    int deleteById(String sId);//删除项目阶段
//
//    int insert(PrStage record);
//
//    int insertSelective(PrStage record);
//
//    PrStage selectByPrimaryKey(String sId);
//
//    int updateByPrimaryKeySelective(PrStage record);
//
//    int updateByPrimaryKey(PrStage record);
}