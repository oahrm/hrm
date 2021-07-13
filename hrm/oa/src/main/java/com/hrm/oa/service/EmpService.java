package com.hrm.oa.service;

import com.hrm.oa.entity.Emp;

import java.util.List;

/**
 * 业务类接口
 */
public interface EmpService {
    List<Emp> findByName(String name);

    List<Emp> findEmpByDeptIdAndRanks(Emp emp);

    List<Emp> findEmpByParenId(Emp emp);

    List<Emp> findAllEmp();

    Emp findEmpByEmpId(String empId);

    Integer countEmpByParentId(String empId);

    int updateEmpByEmpId(Emp emp);
}
