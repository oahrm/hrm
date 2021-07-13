package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpAssets;
import com.hrm.oa.dao.EmpAssetsDao;
import com.hrm.oa.service.EmpAssetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpAssets)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 22:06:12
 */
@Service("empAssetsService")
public class EmpAssetsServiceImpl implements EmpAssetsService {
    @Resource
    private EmpAssetsDao empAssetsDao;

    /**
     * 查询某个员工的所有资产
     * @param empId
     * @return
     */
    @Override
    public List<EmpAssets> findAssetsByEmpId(String empId) {
        return empAssetsDao.queryByEmpId(empId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmpAssets queryById(String id) {
        return this.empAssetsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<EmpAssets> queryAllByLimit(int offset, int limit) {
        return this.empAssetsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param empAssets 实例对象
     * @return 实例对象
     */
    @Override
    public EmpAssets insert(EmpAssets empAssets) {
        this.empAssetsDao.insert(empAssets);
        return empAssets;
    }

    /**
     * 修改数据
     *
     * @param empAssets 实例对象
     * @return 实例对象
     */
    @Override
    public EmpAssets update(EmpAssets empAssets) {
        this.empAssetsDao.update(empAssets);
        return this.queryById(empAssets.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.empAssetsDao.deleteById(id) > 0;
    }
}
