package com.hrm.oa.controller;

import com.hrm.oa.entity.PrDservice;
import com.hrm.oa.service.PrDserviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrDservice)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:10
 */
@RestController
@Slf4j
public class PrDserviceController {
    /**
     * 服务对象
     */
    @Resource
    private PrDserviceService prDserviceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrDservice selectOne(String id) {
        return this.prDserviceService.queryById(id);
    }

}