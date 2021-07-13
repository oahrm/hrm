package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PeCycleSetting;
import com.hrm.oa.dao.PeCycleSettingDao;
import com.hrm.oa.service.PeCycleSettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeCycleSetting)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 16:44:05
 */
@Service("peCycleSettingService")
@Transactional
public class PeCycleSettingServiceImpl implements PeCycleSettingService {
    @Resource
    private PeCycleSettingDao peCycleSettingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cycleSettingNumber 主键
     * @return 实例对象
     */
    @Override
    public PeCycleSetting queryById(String cycleSettingNumber) {
        return this.peCycleSettingDao.queryById(cycleSettingNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeCycleSetting> queryAllByLimit(int offset, int limit) {
        return this.peCycleSettingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peCycleSetting 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeCycleSetting peCycleSetting) {

        return this.peCycleSettingDao.insert(peCycleSetting);
    }

    /**
     * 修改数据
     *
     * @param peCycleSetting 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeCycleSetting peCycleSetting) {

        return this.peCycleSettingDao.update(peCycleSetting);
    }

    /**
     * 通过主键删除数据
     *
     * @param cycleSettingNumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cycleSettingNumber) {
        return this.peCycleSettingDao.deleteById(cycleSettingNumber) > 0;
    }
}
