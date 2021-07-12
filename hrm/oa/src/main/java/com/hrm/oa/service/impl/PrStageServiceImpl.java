package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrStage;
import com.hrm.oa.dao.PrStageDao;
import com.hrm.oa.service.PrStageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrStage)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:44
 */
@Slf4j
@Service
public class PrStageServiceImpl implements PrStageService {
    @Resource
    private PrStageDao prStageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public PrStage queryById(String sId) {
        return this.prStageDao.queryById(sId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrStage> queryAllByLimit(int offset, int limit) {
        return this.prStageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param prStage 实例对象
     * @return 实例对象
     */
    @Override
    public PrStage insert(PrStage prStage) {
        this.prStageDao.insert(prStage);
        return prStage;
    }

    /**
     * 修改数据
     *
     * @param prStage 实例对象
     * @return 实例对象
     */
    @Override
    public PrStage update(PrStage prStage) {
        this.prStageDao.update(prStage);
        return this.queryById(prStage.getSId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String sId) {
        return this.prStageDao.deleteById(sId) > 0;
    }
}