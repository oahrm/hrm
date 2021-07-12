package com.hrm.oa.dao;

import com.hrm.oa.entity.PeAssessmentResultsShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PeAssessmentResultsShow)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 15:00:32
 */
@Mapper
public interface PeAssessmentResultsShowDao {

    /**
     * 通过ID查询单条数据
     *
     * @param resultId 主键
     * @return 实例对象
     */
    PeAssessmentResultsShow queryById(String resultId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentResultsShow> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 对象列表
     */
    List<PeAssessmentResultsShow> queryAll(PeAssessmentResultsShow peAssessmentResultsShow);

    /**
     * 新增数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 影响行数
     */
    int insert(PeAssessmentResultsShow peAssessmentResultsShow);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentResultsShow> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeAssessmentResultsShow> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentResultsShow> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeAssessmentResultsShow> entities);

    /**
     * 修改数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 影响行数
     */
    int update(PeAssessmentResultsShow peAssessmentResultsShow);

    /**
     * 通过主键删除数据
     *
     * @param resultId 主键
     * @return 影响行数
     */
    int deleteById(String resultId);



}

