package com.hrm.oa.service;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeExamineGrade;

import java.util.List;

/**
 * (PeExamineGrade)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 16:23:59
 */
public interface PeExamineGradeService {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    PeExamineGrade queryById(String scoreId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeExamineGrade> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peExamineGrade 实例对象
     * @return 实例对象
     */
    int insert(PeExamineGrade peExamineGrade);

    /**
     * 修改数据
     *
     * @param peExamineGrade 实例对象
     * @return 实例对象
     */
    PeExamineGrade update(PeExamineGrade peExamineGrade);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    boolean deleteById(String scoreId);

    PageInfo<PeExamineGrade> queryAll(PeExamineGrade peExamineGrade,int page,int pageSize);

}
