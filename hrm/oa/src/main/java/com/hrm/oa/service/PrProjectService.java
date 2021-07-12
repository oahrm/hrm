package com.hrm.oa.service;

import com.hrm.oa.entity.PrProject;
import java.util.List;

/**
 * (PrProject)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:18
 */
public interface PrProjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    PrProject queryById(String pId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrProject> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prProject 实例对象
     * @return 实例对象
     */
    PrProject insert(PrProject prProject);

    /**
     * 修改数据
     *
     * @param prProject 实例对象
     * @return 实例对象
     */
    PrProject update(PrProject prProject);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(String pId);

}