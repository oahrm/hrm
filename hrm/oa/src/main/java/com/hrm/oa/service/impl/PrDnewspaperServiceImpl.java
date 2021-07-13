package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrDnewspaper;
import com.hrm.oa.dao.PrDnewspaperDao;
import com.hrm.oa.service.PrDnewspaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrDnewspaper)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:00
 */
@Slf4j
@Service
public class PrDnewspaperServiceImpl implements PrDnewspaperService {
    @Resource
    private PrDnewspaperDao prDnewspaperDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dnId 主键
     * @return 实例对象
     */
    @Override
    public PrDnewspaper queryById(String dnId) {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PrDnewspaper> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param prDnewspaper 实例对象
     * @return 实例对象
     */
    @Override
    public PrDnewspaper insert(PrDnewspaper prDnewspaper) {
//        this.prDnewspaperDao.insert(prDnewspaper);
        return prDnewspaper;
    }

    /**
     * 修改数据
     *
     * @param prDnewspaper 实例对象
     * @return 实例对象
     */
    @Override
    public PrDnewspaper update(PrDnewspaper prDnewspaper) {
//        this.prDnewspaperDao.update(prDnewspaper);
        return this.queryById(prDnewspaper.getDnId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dnId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String dnId) {
        return true;
    }
}