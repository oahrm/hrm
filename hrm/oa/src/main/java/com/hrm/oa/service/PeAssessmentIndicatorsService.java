package com.hrm.oa.service;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;

import java.util.List;

/**
 * (PeAssessmentIndicators)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 14:24:41
 */
public interface PeAssessmentIndicatorsService {

    /**
     * 通过ID查询单条数据
     *
     * @param indexNumber 主键
     * @return 实例对象
     */
    PeAssessmentIndicators queryById(String indexNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentIndicators> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 实例对象
     */
    int insert(PeAssessmentIndicators peAssessmentIndicators);

    /**
     * 修改数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 实例对象
     */
    int update(PeAssessmentIndicators peAssessmentIndicators);

    /**
     * 通过主键删除数据
     *
     * @param indexNumber 主键
     * @return 是否成功
     */
    boolean deleteById(String indexNumber);

    List<PeAssessmentIndicators> queryAll(PeAssessmentIndicators peAssessmentIndicators);

}
