package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PeDepartment;
import com.hrm.oa.dao.PeDepartmentDao;
import com.hrm.oa.service.PeDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeDepartment)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 21:02:08
 */
@Service("peDepartmentService")
public class PeDepartmentServiceImpl implements PeDepartmentService {
    @Resource
    private PeDepartmentDao peDepartmentDao;
    /**
     * 新增数据
     *
     * @param peDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public PeDepartment insert(PeDepartment peDepartment) {
        this.peDepartmentDao.insert(peDepartment);
        return peDepartment;
    }

    /**
     * 查找所有部门
     *
     * @return 实例对象的集合
     */
    @Override
    public List<PeDepartment> findAllDept() {
        return peDepartmentDao.selectAll();
    }
}
