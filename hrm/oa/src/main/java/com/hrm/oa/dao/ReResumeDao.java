package com.hrm.oa.dao;

import com.hrm.oa.entity.ReResumeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReResumeDao {
    int deleteByPrimaryKey(String resumeId);

    int insert(ReResumeEntity record);

    int insertSelective(ReResumeEntity record);

    ReResumeEntity selectByPrimaryKey(String resumeId);

    int updateByPrimaryKeySelective(ReResumeEntity record);

    int updateByPrimaryKey(ReResumeEntity record);

    List<ReResumeEntity> findAll();
    int tit();
}