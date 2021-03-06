package com.hrm.oa.dao;

import com.hrm.oa.entity.ReInterviewEntity;
import com.hrm.oa.entity.ReInterviewEntitytime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReInterviewDao {
    int deleteByPrimaryKey(String id);

    int insert(ReInterviewEntity record);

    int insertSelective(ReInterviewEntity record);

    ReInterviewEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReInterviewEntity record);

    int updateByPrimaryKey(ReInterviewEntity record);

    List<ReInterviewEntity> findAll();
    int updatetonguo(String id);
    int tit();

    void updataguanbi(String id);

    void updataruyong(String id);

    List<ReInterviewEntitytime> selectruqu();
}