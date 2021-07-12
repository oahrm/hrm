package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrDetailproject;
import com.hrm.oa.dao.PrDetailprojectDao;
import com.hrm.oa.service.PrDetailprojectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrDetailproject)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:32:45
 */
@Slf4j
@Service
public class PrDetailprojectServiceImpl implements PrDetailprojectService {
    @Resource
    private PrDetailprojectDao prDetailprojectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    @Override
    public PrDetailproject queryById(String dId) {
        return this.prDetailprojectDao.queryById(dId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrDetailproject> queryAllByLimit(int offset, int limit) {
        return this.prDetailprojectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param prDetailproject 实例对象
     * @return 实例对象
     */
    @Override
    public PrDetailproject insert(PrDetailproject prDetailproject) {
        this.prDetailprojectDao.insert(prDetailproject);
        return prDetailproject;
    }

    /**
     * 修改数据
     *
     * @param prDetailproject 实例对象
     * @return 实例对象
     */
    @Override
    public PrDetailproject update(PrDetailproject prDetailproject) {
        this.prDetailprojectDao.update(prDetailproject);
        return this.queryById(prDetailproject.getDId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String dId) {
        return this.prDetailprojectDao.deleteById(dId) > 0;
    }
}