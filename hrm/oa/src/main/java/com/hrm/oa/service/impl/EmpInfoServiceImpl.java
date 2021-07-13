package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpInfo;
import com.hrm.oa.dao.EmpInfoDao;
import com.hrm.oa.service.EmpInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工个人信息表(EmpInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 00:43:47
 */
@Service("empInfoService")
public class EmpInfoServiceImpl implements EmpInfoService {
    @Resource
    private EmpInfoDao empInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param empId 主键
     * @return 实例对象
     */
    @Override
    public EmpInfo queryById(String empId) {
        return this.empInfoDao.queryById(empId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<EmpInfo> queryAllByLimit(int offset, int limit) {
        return this.empInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param empInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmpInfo insert(EmpInfo empInfo) {
        this.empInfoDao.insert(empInfo);
        return empInfo;
    }

    /**
     * 修改数据
     *
     * @param empInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmpInfo update(EmpInfo empInfo) {
        this.empInfoDao.update(empInfo);
        return this.queryById(empInfo.getEmpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param empId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String empId) {
        return this.empInfoDao.deleteById(empId) > 0;
    }
}
