package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrProject;
import com.hrm.oa.dao.PrProjectDao;
import com.hrm.oa.service.PrProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrProject)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:18
 */
@Slf4j
@Service
public class PrProjectServiceImpl implements PrProjectService {
    @Resource
    private PrProjectDao prProjectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public PrProject queryById(String pId) {
        return this.prProjectDao.queryById(pId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrProject> queryAllByLimit(int offset, int limit) {
        return this.prProjectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param prProject 实例对象
     * @return 实例对象
     */
    @Override
    public PrProject insert(PrProject prProject) {
        this.prProjectDao.insert(prProject);
        return prProject;
    }

    /**
     * 修改数据
     *
     * @param prProject 实例对象
     * @return 实例对象
     */
    @Override
    public PrProject update(PrProject prProject) {
        this.prProjectDao.update(prProject);
        return this.queryById(prProject.getPId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String pId) {
        return this.prProjectDao.deleteById(pId) > 0;
    }
}