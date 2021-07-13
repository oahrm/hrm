package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpEducationalBackground;
import com.hrm.oa.dao.EmpEducationalBackgroundDao;
import com.hrm.oa.service.EmpEducationalBackgroundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学历背景表(EmpEducationalBackground)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 14:14:02
 */
@Service("empEducationalBackgroundService")
public class EmpEducationalBackgroundServiceImpl implements EmpEducationalBackgroundService {
    @Resource
    private EmpEducationalBackgroundDao empEducationalBackgroundDao;

    /**
     * 查询某个人的教育背景
     * @param empId
     * @return
     */
    @Override
    public List<EmpEducationalBackground> queryByEduEmpId(String empId) {
        return empEducationalBackgroundDao.queryByEduEmpId(empId);
    }
}
