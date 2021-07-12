package com.hrm.oa.controller;

import com.hrm.oa.entity.PrService;
import com.hrm.oa.service.PrServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrService)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:37
 */
@RestController
@Slf4j
public class PrServiceController {
    /**
     * 服务对象
     */
    @Resource
    private PrServiceService prServiceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrService selectOne(String id) {
        return this.prServiceService.queryById(id);
    }

}