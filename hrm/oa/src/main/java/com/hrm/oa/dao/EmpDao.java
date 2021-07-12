package com.hrm.oa.dao;

import com.hrm.oa.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDao {
    int deleteByPrimaryKey(String id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    /**
     * 通过在职状态查询员工
     * @return
     */
    List<Emp> selectAllByOnTheJobStatus();

    /**
     * 通过姓名模糊查询员工
     * @return
     */
    List<Emp> selectByName(String name);
}