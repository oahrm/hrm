package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeExamineGrade;
import com.hrm.oa.dao.PeExamineGradeDao;
import com.hrm.oa.service.PeExamineGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeExamineGrade)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 16:23:59
 */
@Service("peExamineGradeService")
public class PeExamineGradeServiceImpl implements PeExamineGradeService {
    @Resource
    private PeExamineGradeDao peExamineGradeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    @Override
    public PeExamineGrade queryById(String scoreId) {
        return this.peExamineGradeDao.queryById(scoreId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeExamineGrade> queryAllByLimit(int offset, int limit) {
        return this.peExamineGradeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peExamineGrade 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeExamineGrade peExamineGrade) {
        return this.peExamineGradeDao.insert(peExamineGrade);
    }

    /**
     * 修改数据
     *
     * @param peExamineGrade 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeExamineGrade peExamineGrade) {

        return this.peExamineGradeDao.update(peExamineGrade);
    }

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String scoreId) {
        return this.peExamineGradeDao.deleteById(scoreId) > 0;
    }

    @Override
    public PageInfo<PeExamineGrade> queryAll(PeExamineGrade peExamineGrade,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<PeExamineGrade> peExamineGrades =  peExamineGradeDao.queryAll(peExamineGrade);
        PageInfo<PeExamineGrade> pageInfo = new PageInfo<>(peExamineGrades,pageSize);
        return pageInfo;
    }
}
