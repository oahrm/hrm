package com.hrm.oa.dao;

import com.hrm.oa.entity.PrSchedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrScheduleDao {
    int insertpr_schedule(PrSchedule record);//新增任务日程
//    int deleteByPrimaryKey(String scId);
//
//    int insert(PrSchedule record);
//
//    int insertSelective(PrSchedule record);
//
//    PrSchedule selectByPrimaryKey(String scId);
//
//    int updateByPrimaryKeySelective(PrSchedule record);
//
//    int updateByPrimaryKey(PrSchedule record);
}