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
     * 通过姓名模糊查询员工
     * @return
     */
    List<Emp> selectByName(String name);

    /**
     * 通过部门和职级查询员工
     * @return
     */
    List<Emp> selectByDeptIdAndRanks(Emp emp);

    /**
     * 通过上级查找员工
     * @return
     */
    List<Emp> selectEmpByParenId(Emp emp);

    List<Emp> selectByOnTheJobStatus();
}