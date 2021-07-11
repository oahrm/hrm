package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PeAssessmentSection;
import com.hrm.oa.dao.PeAssessmentSectionDao;
import com.hrm.oa.service.PeAssessmentSectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeAssessmentSection)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 15:15:51
 */
@Service("peAssessmentSectionService")
public class PeAssessmentSectionServiceImpl implements PeAssessmentSectionService {
    @Resource
    private PeAssessmentSectionDao peAssessmentSectionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    @Override
    public PeAssessmentSection queryById(String scoreId) {
        return this.peAssessmentSectionDao.queryById(scoreId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeAssessmentSection> queryAllByLimit(int offset, int limit) {
        return this.peAssessmentSectionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peAssessmentSection 实例对象
     * @return 实例对象
     */
    @Override
    public PeAssessmentSection insert(PeAssessmentSection peAssessmentSection) {
        this.peAssessmentSectionDao.insert(peAssessmentSection);
        return peAssessmentSection;
    }

    /**
     * 修改数据
     *
     * @param peAssessmentSection 实例对象
     * @return 实例对象
     */
    @Override
    public PeAssessmentSection update(PeAssessmentSection peAssessmentSection) {
        this.peAssessmentSectionDao.update(peAssessmentSection);
        return this.queryById(peAssessmentSection.getScoreId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String scoreId) {
        return this.peAssessmentSectionDao.deleteById(scoreId) > 0;
    }
}