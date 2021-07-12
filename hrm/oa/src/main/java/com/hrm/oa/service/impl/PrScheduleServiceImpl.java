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

    @Override
    public PrSchedule insertpr_schedule(PrSchedule record) {
        int pr_scId=prScheduleDao.insertpr_schedule(record);
        return record;
    }
}