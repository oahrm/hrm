package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工个人信息表(EmpInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 00:43:46
 */
@Mapper
public interface EmpInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param empId 主键
     * @return 实例对象
     */
    EmpInfo queryById(String empId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param empInfo 实例对象
     * @return 对象列表
     */
    List<EmpInfo> queryAll(EmpInfo empInfo);

    /**
     * 新增数据
     *
     * @param empInfo 实例对象
     * @return 影响行数
     */
    int insert(EmpInfo empInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmpInfo> entities);

    /**
     * 修改数据
     *
     * @param empInfo 实例对象
     * @return 影响行数
     */
    int update(EmpInfo empInfo);

    /**
     * 通过主键删除数据
     *
     * @param empId 主键
     * @return 影响行数
     */
    int deleteById(String empId);

}

