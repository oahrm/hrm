package com.hrm.oa.service;

import com.hrm.oa.entity.Emp;
import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.entity.ReOffer;

import java.util.List;

/**
 * 业务类接口
 */
public interface EmpService {
    List<Emp> findByName(Emp emp);

    //员工入职将offer表数据新增到emp表
    Emp insertEmp_ReOffer(Emp emp);

    List<Emp> findEmpByDeptIdAndRanks(Emp emp);

    List<Emp> findEmpByParenId(Emp emp);

    List<Emp> findAllEmp();

    //查询员工表为实习期的员工到转正页面
    List<Emp> findEmpOersZz();

    //查询员工表已转正的员工到已转正页面
    List<Emp> findEmpOersYZz();

    //将转正状态更改为1
    int updateEmpOersZz(String empId);


    Emp findEmpByEmpId(String empId);

    Integer countEmpByParentId(String empId);

    int updateEmpByEmpId(Emp emp);

    List<Emp> selectAllByDeptId(String deptId);
}
