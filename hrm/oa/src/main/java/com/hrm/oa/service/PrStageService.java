package com.hrm.oa.service;

import com.hrm.oa.entity.PrStage;
import java.util.List;

/**
 * (PrStage)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:44
 */
public interface PrStageService {
    PrStage deleteById(String sId);//删除项目阶段

    PrStage insertpr_stage(PrStage record);//新增项目阶段

    List<PrStage> selectAllpr_stage();//查询所有项目阶段
}