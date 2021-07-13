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


    /**
     * 通过姓名模糊查询员工
     * @return
     */
    List<Emp> selectByName(Emp emp);

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

    /**
     * 查询所有在职员工
     * @return
     */
    List<Emp> selectByOnTheJobStatus();

    /**
     * 查询每个员工的直接下属数量
     */
    Integer empCount(String parentId);

    /**
     * 查询每个员工的直接下属数量
     */
    int updateByPrimaryKey(Emp emp);

    List<Emp> selectAllByDeptId(String deptId);
}