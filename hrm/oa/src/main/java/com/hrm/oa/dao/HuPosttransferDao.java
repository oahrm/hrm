package com.hrm.oa.dao;

import com.hrm.oa.entity.HuPosttransfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工调岗记录表(HuPosttransfer)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 20:11:14
 */
@Mapper
public interface HuPosttransferDao {

    /**
     * 查询员工的调岗数据
     */
    List<HuPosttransfer> queryByEmpId(String empId);

    /**
     * 新增数据
     *
     * @param huPosttransfer 实例对象
     * @return 影响行数
     */
    int insert(HuPosttransfer huPosttransfer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<HuPosttransfer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<HuPosttransfer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<HuPosttransfer> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<HuPosttransfer> entities);

}

