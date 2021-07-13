package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpFamilyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmpFamilyInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 03:21:13
 */
@Mapper
public interface EmpFamilyInfoDao {

    /**
     *查询员工的家庭成员
     */
    List<EmpFamilyInfo> queryByEmpId(String empId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpFamilyInfo queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EmpFamilyInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param empFamilyInfo 实例对象
     * @return 对象列表
     */
    List<EmpFamilyInfo> queryAll(EmpFamilyInfo empFamilyInfo);

    /**
     * 新增数据
     *
     * @param empFamilyInfo 实例对象
     * @return 影响行数
     */
    int insert(EmpFamilyInfo empFamilyInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpFamilyInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpFamilyInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpFamilyInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmpFamilyInfo> entities);

    /**
     * 修改数据
     *
     * @param empFamilyInfo 实例对象
     * @return 影响行数
     */
    int update(EmpFamilyInfo empFamilyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

