package com.hrm.oa.service;

import com.hrm.oa.entity.PrSchedule;
import java.util.List;

/**
 * (PrSchedule)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:28
 */
public interface PrScheduleService {

    /**
     * 通过ID查询单条数据
     *
     * @param scId 主键
     * @return 实例对象
     */
    PrSchedule queryById(String scId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PrSchedule> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param prSchedule 实例对象
     * @return 实例对象
     */
    PrSchedule insert(PrSchedule prSchedule);

    /**
     * 修改数据
     *
     * @param prSchedule 实例对象
     * @return 实例对象
     */
    PrSchedule update(PrSchedule prSchedule);

    /**
     * 通过主键删除数据
     *
     * @param scId 主键
     * @return 是否成功
     */
    boolean deleteById(String scId);

}