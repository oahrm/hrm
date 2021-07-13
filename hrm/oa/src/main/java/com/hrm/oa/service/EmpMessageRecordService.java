package com.hrm.oa.service;

import com.hrm.oa.entity.EmpMessageRecord;

import java.util.List;

/**
 * (EmpMessageRecord)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 15:20:13
 */
public interface EmpMessageRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmpMessageRecord queryById(String id);

    /**
     * 新增数据
     *
     * @param empMessageRecord 实例对象
     * @return 实例对象
     */
    EmpMessageRecord insert(EmpMessageRecord empMessageRecord);

    int addAllMessage(List<EmpMessageRecord> list);

    /**
     * 修改数据
     *
     * @param empMessageRecord 实例对象
     * @return 实例对象
     */
    EmpMessageRecord update(EmpMessageRecord empMessageRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
