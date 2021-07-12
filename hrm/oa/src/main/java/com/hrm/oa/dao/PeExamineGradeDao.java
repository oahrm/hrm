package com.hrm.oa.dao;

import com.hrm.oa.entity.PeExamineGrade;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PeExamineGrade)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 16:23:59
 */
@Mapper
public interface PeExamineGradeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    PeExamineGrade queryById(String scoreId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeExamineGrade> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peExamineGrade 实例对象
     * @return 对象列表
     */
    List<PeExamineGrade> queryAll(PeExamineGrade peExamineGrade);

    /**
     * 新增数据
     *
     * @param peExamineGrade 实例对象
     * @return 影响行数
     */
    int insert(PeExamineGrade peExamineGrade);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeExamineGrade> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeExamineGrade> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeExamineGrade> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeExamineGrade> entities);

    /**
     * 修改数据
     *
     * @param peExamineGrade 实例对象
     * @return 影响行数
     */
    int update(PeExamineGrade peExamineGrade);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 影响行数
     */
    int deleteById(String scoreId);

}

