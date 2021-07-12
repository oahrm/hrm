package com.hrm.oa.controller;

import com.hrm.oa.entity.PrTask;
import com.hrm.oa.service.PrTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrTask)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:52
 */
@RestController
@Slf4j
public class PrTaskController {
    /**
     * 服务对象
     */
    @Resource
    private PrTaskService prTaskService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrTask selectOne(String id) {
        return this.prTaskService.queryById(id);
    }

}