package com.hrm.oa.service;

import com.hrm.oa.entity.PeAssessmentSection;

import java.util.List;

/**
 * (PeAssessmentSection)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 15:15:50
 */
public interface PeAssessmentSectionService {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    PeAssessmentSection queryById(String scoreId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentSection> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peAssessmentSection 实例对象
     * @return 实例对象
     */
    int insert(PeAssessmentSection peAssessmentSection);

    /**
     * 修改数据
     *
     * @param peAssessmentSection 实例对象
     * @return 实例对象
     */
    int update(PeAssessmentSection peAssessmentSection);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    boolean deleteById(String scoreId);

}
