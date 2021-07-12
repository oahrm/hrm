package com.hrm.oa.service;

import com.hrm.oa.entity.PrDetailproject;
import java.util.List;

/**
 * (PrDetailproject)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:32:45
 */
public interface PrDetailprojectService {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    PrDetailproject queryById(String dId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrDetailproject> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prDetailproject 实例对象
     * @return 实例对象
     */
    PrDetailproject insert(PrDetailproject prDetailproject);

    /**
     * 修改数据
     *
     * @param prDetailproject 实例对象
     * @return 实例对象
     */
    PrDetailproject update(PrDetailproject prDetailproject);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    boolean deleteById(String dId);

}