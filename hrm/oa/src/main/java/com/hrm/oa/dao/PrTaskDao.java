package com.hrm.oa.dao;

import com.hrm.oa.entity.PrTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrTaskDao {
    int insertpr_task(PrTask record);//新增项目任务

    List<PrTask> selectAllpr_task();//查询所有项目任务

    List<PrTask> selectNBegainpr_task();//查询未开始的项目任务

    List<PrTask> selectBegainpr_task();//查询开始的项目任务

    int updatepr_task(PrTask record);//修改项目任务
//    int deleteByPrimaryKey(String tId);
//
//    int insert(PrTask record);
//
//    int insertSelective(PrTask record);
//
//    PrTask selectByPrimaryKey(String tId);
//
//    int updateByPrimaryKeySelective(PrTask record);
//
//    int updateByPrimaryKey(PrTask record);
}