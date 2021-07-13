package com.hrm.oa.dao;

import com.hrm.oa.entity.CwTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CwTimeDao {
    int deleteByPrimaryKey(Integer kqtimeId);

    int insert(CwTime record);

    int insertSelective(CwTime record);

//    CwTime selectByPrimaryKey(Integer kqtimeId);

    int updateByPrimaryKeySelective(CwTime record);

    int updateBytime(CwTime record);

    List<CwTime>selectBytime();
}