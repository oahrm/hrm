package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.dao.PeAssessmentIndicatorsDao;
import com.hrm.oa.service.PeAssessmentIndicatorsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeAssessmentIndicators)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 14:24:41
 */
@Service("peAssessmentIndicatorsService")
@Transactional
public class PeAssessmentIndicatorsServiceImpl implements PeAssessmentIndicatorsService {
    @Resource
    private PeAssessmentIndicatorsDao peAssessmentIndicatorsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param indexNumber 主键
     * @return 实例对象
     */
    @Override
    public PeAssessmentIndicators queryById(String indexNumber) {
        return this.peAssessmentIndicatorsDao.queryById(indexNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeAssessmentIndicators> queryAllByLimit(int offset, int limit) {
        return this.peAssessmentIndicatorsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeAssessmentIndicators peAssessmentIndicators) {

        return this.peAssessmentIndicatorsDao.insert(peAssessmentIndicators);
    }

    /**
     * 修改数据
     *
     * @param peAssessmentIndicators 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeAssessmentIndicators peAssessmentIndicators) {

        return this.peAssessmentIndicatorsDao.update(peAssessmentIndicators);
    }

    /**
     * 通过主键删除数据
     *
     * @param indexNumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String indexNumber) {
        return this.peAssessmentIndicatorsDao.deleteById(indexNumber) > 0;
    }

    @Override
    public List<PeAssessmentIndicators> queryAll(PeAssessmentIndicators peAssessmentIndicators) {
//        PageHelper.startPage(page,pageSize);
        List<PeAssessmentIndicators> peAssessmentIndicatorsList =  peAssessmentIndicatorsDao.queryAll(peAssessmentIndicators);
//        PageInfo<PeAssessmentIndicators> pageInfo = new PageInfo<>(peAssessmentIndicatorsList,pageSize);
        return peAssessmentIndicatorsList;
    }
}
