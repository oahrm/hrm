package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeAssessmentResultsShow;
import com.hrm.oa.dao.PeAssessmentResultsShowDao;
import com.hrm.oa.service.PeAssessmentResultsShowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeAssessmentResultsShow)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 15:00:34
 */
@Service("peAssessmentResultsShowService")
@Transactional
public class PeAssessmentResultsShowServiceImpl implements PeAssessmentResultsShowService {
    @Resource
    private PeAssessmentResultsShowDao peAssessmentResultsShowDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resultId 主键
     * @return 实例对象
     */
    @Override
    public PeAssessmentResultsShow queryById(String resultId) {
        return this.peAssessmentResultsShowDao.queryById(resultId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeAssessmentResultsShow> queryAllByLimit(int offset, int limit) {
        return this.peAssessmentResultsShowDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeAssessmentResultsShow peAssessmentResultsShow) {

        return this.peAssessmentResultsShowDao.insert(peAssessmentResultsShow);
    }

    /**
     * 修改数据
     *
     * @param peAssessmentResultsShow 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeAssessmentResultsShow peAssessmentResultsShow) {

        return  this.peAssessmentResultsShowDao.update(peAssessmentResultsShow);
    }

    /**
     * 通过主键删除数据
     *
     * @param resultId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String resultId) {
        return this.peAssessmentResultsShowDao.deleteById(resultId) > 0;
    }

    @Override
    public PageInfo<PeAssessmentResultsShow> queryAll(PeAssessmentResultsShow peAssessmentResultsShow, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PeAssessmentResultsShow> peAssessmentResultsShows =  peAssessmentResultsShowDao.queryAll(peAssessmentResultsShow);
        PageInfo<PeAssessmentResultsShow> pageInfo = new PageInfo<>(peAssessmentResultsShows,pageSize);
        return pageInfo;
    }
}
