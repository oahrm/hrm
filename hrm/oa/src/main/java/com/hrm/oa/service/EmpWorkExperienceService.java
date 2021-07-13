package com.hrm.oa.service;

import com.hrm.oa.entity.EmpWorkExperience;

import java.util.List;

/**
 * (EmpWorkExperience)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 11:51:32
 */
public interface EmpWorkExperienceService {

    /**
     * 通过员工ID查询数据
     */
    List<EmpWorkExperience> queryByEmpId(String empId);

    /**
     * 新增数据
     *
     * @param empWorkExperience 实例对象
     * @return 实例对象
     */
    EmpWorkExperience insert(EmpWorkExperience empWorkExperience);


}
