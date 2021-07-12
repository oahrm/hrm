package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PeAssessmentSetting;
import com.hrm.oa.dao.PeAssessmentSettingDao;
import com.hrm.oa.service.PeAssessmentSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考核设置表(PeAssessmentSetting)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 00:53:02
 */
@Service("peAssessmentSettingService")
public class PeAssessmentSettingServiceImpl implements PeAssessmentSettingService {
    @Resource
    private PeAssessmentSettingDao peAssessmentSettingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param assSettingId 主键
     * @return 实例对象
     */
    @Override
    public PeAssessmentSetting queryById(String assSettingId) {
        return this.peAssessmentSettingDao.queryById(assSettingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeAssessmentSetting> queryAllByLimit(int offset, int limit) {
        return this.peAssessmentSettingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeAssessmentSetting peAssessmentSetting) {

        return this.peAssessmentSettingDao.insert(peAssessmentSetting);
    }

    /**
     * 修改数据
     *
     * @param peAssessmentSetting 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeAssessmentSetting peAssessmentSetting) {

        return this.peAssessmentSettingDao.update(peAssessmentSetting);
    }

    /**
     * 通过主键删除数据
     *
     * @param assSettingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String assSettingId) {
        return this.peAssessmentSettingDao.deleteById(assSettingId) > 0;
    }
}
