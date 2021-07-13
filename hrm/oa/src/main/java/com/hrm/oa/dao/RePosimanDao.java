package com.hrm.oa.dao;

import com.hrm.oa.entity.RePosimanEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RePosimanDao {
    int deleteByPrimaryKey(String pmId);

    int insert(RePosimanEntity record);

    int insertSelective(RePosimanEntity record);

    RePosimanEntity selectByPrimaryKey(String pmId);

    int updateByPrimaryKeySelective(RePosimanEntity record);

    int updateByPrimaryKey(RePosimanEntity record);

    List<RePosimanEntity> findAll();

    int staffnum();
    int actualnum();
    int tit();
}