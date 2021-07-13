package com.hrm.oa.service;

import com.hrm.oa.entity.EmpInfo;

import java.util.List;

/**
 * 员工个人信息表(EmpInfo)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 00:43:47
 */
public interface EmpInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param empId 主键
     * @return 实例对象
     */
    EmpInfo queryById(String empId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param empInfo 实例对象
     * @return 实例对象
     */
    EmpInfo insert(EmpInfo empInfo);

    /**
     * 修改数据
     *
     * @param empInfo 实例对象
     * @return 实例对象
     */
    EmpInfo update(EmpInfo empInfo);

    /**
     * 通过主键删除数据
     *
     * @param empId 主键
     * @return 是否成功
     */
    boolean deleteById(String empId);

}
