package com.hrm.oa.service;

import com.hrm.oa.entity.PrDnewspaper;
import java.util.List;

/**
 * (PrDnewspaper)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:00
 */
public interface PrDnewspaperService {

    /**
     * 通过ID查询单条数据
     *
     * @param dnId 主键
     * @return 实例对象
     */
    PrDnewspaper queryById(String dnId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrDnewspaper> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prDnewspaper 实例对象
     * @return 实例对象
     */
    PrDnewspaper insert(PrDnewspaper prDnewspaper);

    /**
     * 修改数据
     *
     * @param prDnewspaper 实例对象
     * @return 实例对象
     */
    PrDnewspaper update(PrDnewspaper prDnewspaper);

    /**
     * 通过主键删除数据
     *
     * @param dnId 主键
     * @return 是否成功
     */
    boolean deleteById(String dnId);

}