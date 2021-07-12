package com.hrm.oa.service;

import com.hrm.oa.entity.PeIndexList;

import java.util.List;

/**
 * 指标列表(PeIndexList)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 16:26:26
 */
public interface PeIndexListService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    PeIndexList queryById(String indexId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PeIndexList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param peIndexList 实例对象
     * @return 实例对象
     */
    int insert(PeIndexList peIndexList);

    /**
     * 修改数据
     *
     * @param peIndexList 实例对象
     * @return 实例对象
     */
    int update(PeIndexList peIndexList);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(String indexId);

    List<PeIndexList> queryAllIndexList(PeIndexList peIndexList);

}
