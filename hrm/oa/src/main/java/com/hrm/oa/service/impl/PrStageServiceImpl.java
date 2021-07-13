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

    @Override
    public PrStage deleteById(String sId) {
        PrStage prStage=new PrStage();
        int pr_sId=prStageDao.deleteById(sId);
        return prStage;
    }

    @Override
    public PrStage insertpr_stage(PrStage record) {
        int pr_sId=prStageDao.insertpr_stage(record);
        return record;
    }

    @Override
    public List<PrStage> selectAllpr_stage() {
        return prStageDao.selectAllpr_stage();
    }
}