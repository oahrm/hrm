package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpAssets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmpAssets)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 22:06:12
 */
@Mapper
public interface EmpAssetsDao {

    /**
     * 通过员工ID查询数据
     */
    List<EmpAssets> queryByEmpId(String empId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpAssets queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpAssets> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param empAssets 实例对象
     * @return 对象列表
     */
    List<EmpAssets> queryAll(EmpAssets empAssets);

    /**
     * 新增数据
     *
     * @param empAssets 实例对象
     * @return 影响行数
     */
    int insert(EmpAssets empAssets);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpAssets> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpAssets> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpAssets> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmpAssets> entities);

    /**
     * 修改数据
     *
     * @param empAssets 实例对象
     * @return 影响行数
     */
    int update(EmpAssets empAssets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

