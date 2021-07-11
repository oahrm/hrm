package com.hrm.oa.dao;

import com.hrm.oa.entity.ReJobRequirementsEntity;

public interface ReJobRequirementsDao {
    int deleteByPrimaryKey(String jobId);

    int insert(ReJobRequirementsEntity record);

    int insertSelective(ReJobRequirementsEntity record);

    ReJobRequirementsEntity selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(ReJobRequirementsEntity record);

    int updateByPrimaryKey(ReJobRequirementsEntity record);
}