package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PeIndexList;
import com.hrm.oa.dao.PeIndexListDao;
import com.hrm.oa.service.PeIndexListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 指标列表(PeIndexList)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 16:26:26
 */
@Service("peIndexListService")
@Transactional
public class PeIndexListServiceImpl implements PeIndexListService {
    @Resource
    private PeIndexListDao peIndexListDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public PeIndexList queryById(String indexId) {
        return this.peIndexListDao.queryById(indexId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PeIndexList> queryAllByLimit(int offset, int limit) {
        return this.peIndexListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param peIndexList 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PeIndexList peIndexList) {

        return this.peIndexListDao.insert(peIndexList);
    }

    /**
     * 修改数据
     *
     * @param peIndexList 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PeIndexList peIndexList) {

        return this.peIndexListDao.update(peIndexList);
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String indexId) {
        return this.peIndexListDao.deleteById(indexId) > 0;
    }

    @Override
    public List<PeIndexList> queryAllIndexList(PeIndexList peIndexList) {
        List<PeIndexList> peIndexLists = peIndexListDao.queryAll(peIndexList);
        return peIndexLists;
    }

}
