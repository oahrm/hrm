package com.hrm.oa.service;

import com.hrm.oa.entity.PrDservice;
import java.util.List;

/**
 * (PrDservice)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:10
 */
public interface PrDserviceService {

    /**
     * 通过ID查询单条数据
     *
     * @param dsId 主键
     * @return 实例对象
     */
    PrDservice queryById(String dsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrDservice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prDservice 实例对象
     * @return 实例对象
     */
    PrDservice insert(PrDservice prDservice);

    /**
     * 修改数据
     *
     * @param prDservice 实例对象
     * @return 实例对象
     */
    PrDservice update(PrDservice prDservice);

    /**
     * 通过主键删除数据
     *
     * @param dsId 主键
     * @return 是否成功
     */
    boolean deleteById(String dsId);

}