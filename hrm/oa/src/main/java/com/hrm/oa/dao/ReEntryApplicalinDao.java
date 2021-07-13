package com.hrm.oa.dao;

import com.hrm.oa.entity.ReEntryApplicalinEntity;
import com.hrm.oa.entity.RePosimanEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReEntryApplicalinDao {
    int deleteByPrimaryKey(String id);

    int insert(ReEntryApplicalinEntity record);

    int insertSelective(ReEntryApplicalinEntity record);

    ReEntryApplicalinEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReEntryApplicalinEntity record);

    int updateByPrimaryKey(ReEntryApplicalinEntity record);

    List<RePosimanEntity> findAll();
    int tit();
}