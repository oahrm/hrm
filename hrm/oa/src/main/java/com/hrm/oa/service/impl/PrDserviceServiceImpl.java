package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrDservice;
import com.hrm.oa.dao.PrDserviceDao;
import com.hrm.oa.service.PrDserviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrDservice)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:10
 */
@Slf4j
@Service
public class PrDserviceServiceImpl implements PrDserviceService {
    @Resource
    private PrDserviceDao prDserviceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dsId 主键
     * @return 实例对象
     */
    @Override
    public PrDservice queryById(String dsId) {
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
    public List<PrDservice> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param prDservice 实例对象
     * @return 实例对象
     */
    @Override
    public PrDservice insert(PrDservice prDservice) {
//        this.prDserviceDao.insert(prDservice);
        return prDservice;
    }

    /**
     * 修改数据
     *
     * @param prDservice 实例对象
     * @return 实例对象
     */
    @Override
    public PrDservice update(PrDservice prDservice) {
//        this.prDserviceDao.update(prDservice);
        return this.queryById(prDservice.getDsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String dsId) {
        return true;
    }
}