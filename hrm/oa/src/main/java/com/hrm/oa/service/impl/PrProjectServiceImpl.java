package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrProject;
import com.hrm.oa.dao.PrProjectDao;
import com.hrm.oa.service.PrProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


    @Override
    public PrProject insertpr_project(PrProject record) {
        int pr_pId=prProjectDao.insertpr_project(record);
        return record;
    }
}