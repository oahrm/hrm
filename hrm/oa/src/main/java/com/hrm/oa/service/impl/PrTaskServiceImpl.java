package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrTask;
import com.hrm.oa.dao.PrTaskDao;
import com.hrm.oa.service.PrTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrTask)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:52
 */
@Slf4j
@Service
public class PrTaskServiceImpl implements PrTaskService {
    @Resource
    private PrTaskDao prTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    @Override
    public PrTask queryById(String tId) {
        return this.prTaskDao.queryById(tId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrTask> queryAllByLimit(int offset, int limit) {
        return this.prTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param prTask 实例对象
     * @return 实例对象
     */
    @Override
    public PrTask insert(PrTask prTask) {
        this.prTaskDao.insert(prTask);
        return prTask;
    }

    /**
     * 修改数据
     *
     * @param prTask 实例对象
     * @return 实例对象
     */
    @Override
    public PrTask update(PrTask prTask) {
        this.prTaskDao.update(prTask);
        return this.queryById(prTask.getTId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String tId) {
        return this.prTaskDao.deleteById(tId) > 0;
    }
}