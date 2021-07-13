package com.hrm.oa.service;

import com.hrm.oa.entity.PeDepartment;

import java.util.List;

/**
 * (PeDepartment)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 21:02:08
 */
public interface PeDepartmentService {

    /**
     * 新增数据
     *
     * @param peDepartment 实例对象
     * @return 实例对象
     */
    PeDepartment insert(PeDepartment peDepartment);

    /**
     * 查找所有部门
     *
     * @return 实例对象的集合
     */
    List<PeDepartment> findAllDept();




}
