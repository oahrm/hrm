package com.hrm.oa.service;

import com.hrm.oa.entity.Emp;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Bkiller
 * @Date: 2021/07/11/14:19
 * @Description:
 */
public interface EmpService {
    List<Emp> findAllTheJobStatusEmpOn();

    List<Emp> findByName(String name);
}
