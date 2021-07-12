package com.hrm.oa.service;

import com.hrm.oa.entity.PrStage;
import java.util.List;

/**
 * (PrStage)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:44
 */
public interface PrStageService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    PrStage queryById(String sId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrStage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prStage 实例对象
     * @return 实例对象
     */
    PrStage insert(PrStage prStage);

    /**
     * 修改数据
     *
     * @param prStage 实例对象
     * @return 实例对象
     */
    PrStage update(PrStage prStage);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(String sId);

}