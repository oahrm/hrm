package com.hrm.oa.dao;

import com.hrm.oa.entity.PeIndexList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 指标列表(PeIndexList)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 16:26:25
 */
@Mapper
public interface PeIndexListDao {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    PeIndexList queryById(String indexId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeIndexList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param peIndexList 实例对象
     * @return 对象列表
     */
    List<PeIndexList> queryAll(PeIndexList peIndexList);

    /**
     * 新增数据
     *
     * @param peIndexList 实例对象
     * @return 影响行数
     */
    int insert(PeIndexList peIndexList);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeIndexList> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PeIndexList> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PeIndexList> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PeIndexList> entities);

    /**
     * 修改数据
     *
     * @param peIndexList 实例对象
     * @return 影响行数
     */
    int update(PeIndexList peIndexList);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(String indexId);


}

