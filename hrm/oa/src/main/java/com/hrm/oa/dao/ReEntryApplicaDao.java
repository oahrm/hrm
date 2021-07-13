package com.hrm.oa.dao;

import com.hrm.oa.entity.ReEntryApplica;

public interface ReEntryApplicaDao {
    int deleteByPrimaryKey(String id);

    int insert(ReEntryApplica record);

    int insertSelective(ReEntryApplica record);

    ReEntryApplica selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReEntryApplica record);

    int updateByPrimaryKey(ReEntryApplica record);
}