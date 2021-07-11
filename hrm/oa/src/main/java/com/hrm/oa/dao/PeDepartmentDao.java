package com.hrm.oa.dao;

import com.hrm.oa.entity.PeDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PeDepartment)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 21:02:08
 */
@Mapper
public interface PeDepartmentDao {
    /**
     * 新增数据
     *
     * @param peDepartment 实例对象
     * @return 影响行数
     */
    int insert(PeDepartment peDepartment);
    /**
     * 查询所有部门
     * @return
     */
    List<PeDepartment> selectAll();

}

