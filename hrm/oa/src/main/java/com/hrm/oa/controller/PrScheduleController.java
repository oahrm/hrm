package com.hrm.oa.controller;

import com.hrm.oa.entity.PrSchedule;
import com.hrm.oa.service.PrScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrSchedule)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:28
 */
@RestController
@Slf4j
public class PrScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private PrScheduleService prScheduleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrSchedule selectOne(String id) {
        return this.prScheduleService.queryById(id);
    }

}