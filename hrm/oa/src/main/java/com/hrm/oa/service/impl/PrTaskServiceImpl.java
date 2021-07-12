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


    @Override
    public PrTask insertpr_task(PrTask record) {
        int pr_tId=prTaskDao.insertpr_task(record);
        return record;
    }

    @Override
    public List<PrTask> selectAllpr_task() {

        return prTaskDao.selectAllpr_task();
    }

    @Override
    public List<PrTask> selectNBegainpr_task() {
        return prTaskDao.selectNBegainpr_task();
    }

    @Override
    public List<PrTask> selectBegainpr_task() {
        return prTaskDao.selectBegainpr_task();
    }

    @Override
    public PrTask updatepr_task(PrTask record) {
        int pr_tId=prTaskDao.updatepr_task(record);
        return record;
    }
}