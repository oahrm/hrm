package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrService;
import com.hrm.oa.dao.PrServiceDao;
import com.hrm.oa.service.PrServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrService)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 20:33:37
 */
@Slf4j
@Service
public class PrServiceServiceImpl implements PrServiceService {
    @Resource
    private PrServiceDao prServiceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param seId 主键
     * @return 实例对象
     */
    @Override
    public PrService queryById(String seId) {
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
    public List<PrService> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param prService 实例对象
     * @return 实例对象
     */
    @Override
    public PrService insert(PrService prService) {
//        this.prServiceDao.insert(prService);
        return prService;
    }

    /**
     * 修改数据
     *
     * @param prService 实例对象
     * @return 实例对象
     */
    @Override
    public PrService update(PrService prService) {
//        this.prServiceDao.update(prService);
        return this.queryById(prService.getSeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param seId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String seId) {
        return true
                ;
    }
}