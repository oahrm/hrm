package com.hrm.oa.controller;

import com.hrm.oa.entity.PrDnewspaper;
import com.hrm.oa.service.PrDnewspaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrDnewspaper)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:00
 */
@RestController
@Slf4j
public class PrDnewspaperController {
    /**
     * 服务对象
     */
    @Resource
    private PrDnewspaperService prDnewspaperService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrDnewspaper selectOne(String id) {
        return this.prDnewspaperService.queryById(id);
    }

}