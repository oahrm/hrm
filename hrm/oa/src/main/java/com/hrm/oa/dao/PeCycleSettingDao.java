package com.hrm.oa.dao;

import com.hrm.oa.entity.PeCycleSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PeCycleSetting)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 16:44:05
 */
@Mapper
public interface PeCycleSettingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cycleSettingNumber 主键
     * @return 实例对象
     */
    PeCycleSetting queryById(String cycleSettingNumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeCycleSetting> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peCycleSetting 实例对象
     * @return 对象列表
     */
    List<PeCycleSetting> queryAll(PeCycleSetting peCycleSetting);

    /**
     * 新增数据
     *
     * @param peCycleSetting 实例对象
     * @return 影响行数
     */
    int insert(PeCycleSetting peCycleSetting);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeCycleSetting> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeCycleSetting> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeCycleSetting> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeCycleSetting> entities);

    /**
     * 修改数据
     *
     * @param peCycleSetting 实例对象
     * @return 影响行数
     */
    int update(PeCycleSetting peCycleSetting);

    /**
     * 通过主键删除数据
     *
     * @param cycleSettingNumber 主键
     * @return 影响行数
     */
    int deleteById(String cycleSettingNumber);

}

