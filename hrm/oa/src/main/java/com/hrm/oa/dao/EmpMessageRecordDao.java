package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpMessageRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmpMessageRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 15:20:13
 */
@Mapper
public interface EmpMessageRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpMessageRecord queryById(String id);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param empMessageRecord 实例对象
     * @return 对象列表
     */
    List<EmpMessageRecord> queryAll(EmpMessageRecord empMessageRecord);

    /**
     * 新增数据
     *
     * @param empMessageRecord 实例对象
     * @return 影响行数
     */
    int insert(EmpMessageRecord empMessageRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpMessageRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpMessageRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpMessageRecord> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmpMessageRecord> entities);

    /**
     * 修改数据
     *
     * @param empMessageRecord 实例对象
     * @return 影响行数
     */
    int update(EmpMessageRecord empMessageRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

