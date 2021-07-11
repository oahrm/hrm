package com.hrm.oa.service;

import com.hrm.oa.entity.PeCycleSetting;

import java.util.List;

/**
 * (PeCycleSetting)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 16:44:05
 */
public interface PeCycleSettingService {

    /**
     * 通过ID查询单条数据
     *
     * @param cycleSettingNumber 主键
     * @return 实例对象
     */
    PeCycleSetting queryById(String cycleSettingNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeCycleSetting> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peCycleSetting 实例对象
     * @return 实例对象
     */
    int insert(PeCycleSetting peCycleSetting);

    /**
     * 修改数据
     *
     * @param peCycleSetting 实例对象
     * @return 实例对象
     */
    int update(PeCycleSetting peCycleSetting);

    /**
     * 通过主键删除数据
     *
     * @param cycleSettingNumber 主键
     * @return 是否成功
     */
    boolean deleteById(String cycleSettingNumber);

}
