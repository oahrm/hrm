package com.hrm.oa.dao;

import com.hrm.oa.entity.PeAssessmentIndicators;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PeAssessmentIndicators)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 14:24:40
 */
public interface PeAssessmentIndicatorsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param indexNumber 主键
     * @return 实例对象
     */
    PeAssessmentIndicators queryById(String indexNumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentIndicators> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peAssessmentIndicators 实例对象
     * @return 对象列表
     */
    List<PeAssessmentIndicators> queryAll(PeAssessmentIndicators peAssessmentIndicators);

    /**
     * 新增数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 影响行数
     */
    int insert(PeAssessmentIndicators peAssessmentIndicators);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentIndicators> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeAssessmentIndicators> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentIndicators> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeAssessmentIndicators> entities);

    /**
     * 修改数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 影响行数
     */
    int update(PeAssessmentIndicators peAssessmentIndicators);

    /**
     * 通过主键删除数据
     *
     * @param indexNumber 主键
     * @return 影响行数
     */
    int deleteById(String indexNumber);

}

