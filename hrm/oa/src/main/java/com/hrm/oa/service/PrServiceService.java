package com.hrm.oa.service;

import com.hrm.oa.entity.PrService;
import java.util.List;

/**
 * (PrService)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:37
 */
public interface PrServiceService {

    /**
     * 通过ID查询单条数据
     *
     * @param seId 主键
     * @return 实例对象
     */
    PrService queryById(String seId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrService> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prService 实例对象
     * @return 实例对象
     */
    PrService insert(PrService prService);

    /**
     * 修改数据
     *
     * @param prService 实例对象
     * @return 实例对象
     */
    PrService update(PrService prService);

    /**
     * 通过主键删除数据
     *
     * @param seId 主键
     * @return 是否成功
     */
    boolean deleteById(String seId);

}