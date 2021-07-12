package com.hrm.oa.dao;

import com.hrm.oa.entity.PeAssessmentSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考核设置表(PeAssessmentSetting)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 00:53:01
 */
@Mapper
public interface PeAssessmentSettingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param assSettingId 主键
     * @return 实例对象
     */
    PeAssessmentSetting queryById(String assSettingId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeAssessmentSetting> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peAssessmentSetting 实例对象
     * @return 对象列表
     */
    List<PeAssessmentSetting> queryAll(PeAssessmentSetting peAssessmentSetting);

    /**
     * 新增数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 影响行数
     */
    int insert(PeAssessmentSetting peAssessmentSetting);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentSetting> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeAssessmentSetting> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeAssessmentSetting> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeAssessmentSetting> entities);

    /**
     * 修改数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 影响行数
     */
    int update(PeAssessmentSetting peAssessmentSetting);

    /**
     * 通过主键删除数据
     *
     * @param assSettingId 主键
     * @return 影响行数
     */
    int deleteById(String assSettingId);

}

