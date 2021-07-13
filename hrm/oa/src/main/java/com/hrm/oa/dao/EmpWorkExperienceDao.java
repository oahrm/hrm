package com.hrm.oa.dao;

import com.hrm.oa.entity.EmpWorkExperience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmpWorkExperience)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 11:51:32
 */
@Mapper
public interface EmpWorkExperienceDao {

    /**
     * 通过员工ID查询数据
     */
    List<EmpWorkExperience> queryByEmpId(String empId);


    /**
     * 新增数据
     *
     * @param empWorkExperience 实例对象
     * @return 影响行数
     */
    int insert(EmpWorkExperience empWorkExperience);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmpWorkExperience> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmpWorkExperience> entities);
}

