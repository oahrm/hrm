package com.hrm.oa.dao;

import com.hrm.oa.entity.CwSummary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CwSummaryDao {
    int deleteByPrimaryKey(Integer summaryId);

    int insert(CwSummary record);

    int insertSelective(CwSummary record);

    CwSummary selectByPrimaryKey(Integer summaryId);

    int updateByPrimaryKeySelective(CwSummary record);

    int updateByPrimaryKey(CwSummary record);
}