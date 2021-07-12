package com.hrm.oa.service;

import com.hrm.oa.entity.PeAssessmentSetting;

import java.util.List;

/**
 * 考核设置表(PeAssessmentSetting)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 00:53:02
 */
public interface PeAssessmentSettingService {

    /**
     * 通过ID查询单条数据
     *
     * @param assSettingId 主键
     * @return 实例对象
     */
    PeAssessmentSetting queryById(String assSettingId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentSetting> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 实例对象
     */
    int insert(PeAssessmentSetting peAssessmentSetting);

    /**
     * 修改数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 实例对象
     */
    int update(PeAssessmentSetting peAssessmentSetting);

    /**
     * 通过主键删除数据
     *
     * @param assSettingId 主键
     * @return 是否成功
     */
    boolean deleteById(String assSettingId);

}
