package com.hrm.oa.service;

import com.hrm.oa.entity.EmpAssets;

import java.util.List;

/**
 * (EmpAssets)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 22:06:12
 */
public interface EmpAssetsService {

    /**
     * 查询某个员工的所有资产
     * @param empId
     * @return
     */
    List<EmpAssets> findAssetsByEmpId(String empId);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpAssets queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpAssets> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param empAssets 实例对象
     * @return 实例对象
     */
    EmpAssets insert(EmpAssets empAssets);

    /**
     * 修改数据
     *
     * @param empAssets 实例对象
     * @return 实例对象
     */
    EmpAssets update(EmpAssets empAssets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
