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

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpFamilyInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param empFamilyInfo 实例对象
     * @return 实例对象
     */
    EmpFamilyInfo insert(EmpFamilyInfo empFamilyInfo);

    /**
     * 修改数据
     *
     * @param empFamilyInfo 实例对象
     * @return 实例对象
     */
    EmpFamilyInfo update(EmpFamilyInfo empFamilyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
