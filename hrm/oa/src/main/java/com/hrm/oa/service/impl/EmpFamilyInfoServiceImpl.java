package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpFamilyInfo;
import com.hrm.oa.dao.EmpFamilyInfoDao;
import com.hrm.oa.service.EmpFamilyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpFamilyInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 03:21:13
 */
@Service("empFamilyInfoService")
public class EmpFamilyInfoServiceImpl implements EmpFamilyInfoService {
    @Resource
    private EmpFamilyInfoDao empFamilyInfoDao;

    /**
     *查询员工的家庭成员
     */
    @Override
    public List<EmpFamilyInfo> queryByEmpId(String empId) {
        return empFamilyInfoDao.queryByEmpId(empId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmpFamilyInfo queryById(String id) {
        return this.empFamilyInfoDao.queryById(id);
    }

}
