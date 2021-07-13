package com.hrm.oa.service;

import com.hrm.oa.entity.EmpFamilyInfo;

import java.util.List;

/**
 * (EmpFamilyInfo)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 03:21:13
 */
public interface EmpFamilyInfoService {

    /**
     *查询员工的家庭成员
     */
    List<EmpFamilyInfo> queryByEmpId(String empId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpFamilyInfo queryById(String id);

}
