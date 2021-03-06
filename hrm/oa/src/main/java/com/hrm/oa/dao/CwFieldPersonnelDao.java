package com.hrm.oa.dao;

import com.hrm.oa.entity.CwFieldPersonnel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CwFieldPersonnelDao {
    int deleteByPrimaryKey(Integer fieldId);

    int insertfile(CwFieldPersonnel cwFieldPersonnel);

    int insertSelective(CwFieldPersonnel record);

//    CwFieldPersonnel selectByPrimaryKey(Integer fieldId);

    int updateByPrimaryKeySelective(CwFieldPersonnel record);

    int updateByPrimaryKey(CwFieldPersonnel record);

    List<CwFieldPersonnel>selectByfile();

    List<CwFieldPersonnel> selectBydept( String filedname);
}