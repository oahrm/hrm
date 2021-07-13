package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpWorkExperience;
import com.hrm.oa.dao.EmpWorkExperienceDao;
import com.hrm.oa.service.EmpWorkExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpWorkExperience)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 11:51:32
 */
@Service("empWorkExperienceService")
public class EmpWorkExperienceServiceImpl implements EmpWorkExperienceService {
    @Resource
    private EmpWorkExperienceDao empWorkExperienceDao;

    /**
     * 查询员工所有工作经历
     */
    @Override
    public List<EmpWorkExperience> queryByEmpId(String empId) {
        return empWorkExperienceDao.queryByEmpId(empId);
    }

    /**
     * 新增数据
     *
     * @param empWorkExperience 实例对象
     * @return 实例对象
     */
    @Override
    public EmpWorkExperience insert(EmpWorkExperience empWorkExperience) {
        this.empWorkExperienceDao.insert(empWorkExperience);
        return empWorkExperience;
    }
}
