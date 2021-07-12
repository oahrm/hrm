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

    @Override
    public PrDetailproject insertpr_detailproject(PrDetailproject record) {
        int pr_dpId=prDetailprojectDao.insertpr_detailproject(record);
        return record;
    }
}