package com.hrm.oa.service;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeAssessmentResultsShow;

import java.util.List;

/**
 * (PeAssessmentResultsShow)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 15:00:33
 */
public interface PeAssessmentResultsShowService {

    /**
     * 通过ID查询单条数据
     *
     * @param resultId 主键
     * @return 实例对象
     */
    PeAssessmentResultsShow queryById(String resultId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentResultsShow> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 实例对象
     */
    int insert(PeAssessmentResultsShow peAssessmentResultsShow);

    /**
     * 修改数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 实例对象
     */
    int update(PeAssessmentResultsShow peAssessmentResultsShow);

    /**
     * 通过主键删除数据
     *
     * @param resultId 主键
     * @return 是否成功
     */
    boolean deleteById(String resultId);

    PageInfo<PeAssessmentResultsShow> queryAll(PeAssessmentResultsShow peAssessmentResultsShow, int page, int pageSize);



}
