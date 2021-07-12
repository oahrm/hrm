package com.hrm.oa.service;

import com.hrm.oa.entity.PrTask;
import java.util.List;

/**
 * (PrTask)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:52
 */
public interface PrTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    PrTask queryById(String tId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrTask> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prTask 实例对象
     * @return 实例对象
     */
    PrTask insert(PrTask prTask);

    /**
     * 修改数据
     *
     * @param prTask 实例对象
     * @return 实例对象
     */
    PrTask update(PrTask prTask);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    boolean deleteById(String tId);

}