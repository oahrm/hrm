package com.hrm.oa.dao;

import com.hrm.oa.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDao {
    int deleteByPrimaryKey(String id);

//    员工入职将offer表数据新增到emp表
    int insertEmp_ReOffer(Emp record);

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

    //查询员工表为实习期的员工到转正页面
    List<Emp> selectEmpOersZz();

    //查询员工表已转正的员工到已转正页面
    List<Emp> selectEmpOersYZz();

    //员工转正将状态改为1正式人员
    int updateEmpOersZz(String empId);

    //未调岗人员
    List<Emp> selectEmpOersWdg();

    //已调岗人员
    List<Emp> selectEmpOersYdg();


    int updateEmp_HuPosttransfer(String empId);


    int updateEmp_HuLiZhi(String empId);

    List<Emp> selectEmpHuLiZhi();

    List<Emp> selectEmpHuYLiZhi();
    //修改deptname部门
    int updateEmp_Deptname(String empId);

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