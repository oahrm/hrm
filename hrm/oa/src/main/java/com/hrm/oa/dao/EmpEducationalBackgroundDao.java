package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpEducationalBackground;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学历背景表(EmpEducationalBackground)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 14:14:01
 */
@Mapper
public interface EmpEducationalBackgroundDao {


    /**
     * 查询某个人的教育背景
     */
    List<EmpEducationalBackground> queryByEduEmpId(String empId);

}

