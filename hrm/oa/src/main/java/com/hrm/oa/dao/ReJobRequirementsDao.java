package com.hrm.oa.dao;

import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.vo.PageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReJobRequirementsDao {
    int deleteByPrimaryKey(String jobId);

    int insert(ReJobRequirementsEntity record);

    int insertSelective(ReJobRequirementsEntity record);

    ReJobRequirementsEntity selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(ReJobRequirementsEntity record);

    int updateByPrimaryKey(ReJobRequirementsEntity record);

    List<RePosimanEntity> findAll();
    //岗位需求人数
    int demandNumsum();
    int sumdemand();

    Map<String, Object> findAll(PageVo pageVo);


}