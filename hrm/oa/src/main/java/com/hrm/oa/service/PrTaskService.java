package com.hrm.oa.service;

import com.hrm.oa.entity.PrTask;
import java.util.List;

/**
 * (PrTask)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 20:33:52
 */
public interface PrTaskService {
    PrTask insertpr_task(PrTask record);//新增项目任务

    List<PrTask> selectAllpr_task();//查询所有项目任务

    List<PrTask> selectNBegainpr_task();//查询未开始的项目任务

    List<PrTask> selectBegainpr_task();//查询开始的项目任务

    PrTask updatepr_task(PrTask record);//修改项目任务
}