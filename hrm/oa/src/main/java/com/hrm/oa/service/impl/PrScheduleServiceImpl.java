package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrSchedule;
import com.hrm.oa.dao.PrScheduleDao;
import com.hrm.oa.service.PrScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrSchedule)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:28
 */
@Slf4j
@Service
public class PrScheduleServiceImpl implements PrScheduleService {
    @Resource
    private PrScheduleDao prScheduleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scId 主键
     * @return 实例对象
     */
    @Override
    public PrSchedule queryById(String scId) {
        return this.prScheduleDao.queryById(scId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrSchedule> queryAllByLimit(int offset, int limit) {
        return this.prScheduleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param prSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public PrSchedule insert(PrSchedule prSchedule) {
        this.prScheduleDao.insert(prSchedule);
        return prSchedule;
    }

    /**
     * 修改数据
     *
     * @param prSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public PrSchedule update(PrSchedule prSchedule) {
        this.prScheduleDao.update(prSchedule);
        return this.queryById(prSchedule.getScId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String scId) {
        return this.prScheduleDao.deleteById(scId) > 0;
    }
}