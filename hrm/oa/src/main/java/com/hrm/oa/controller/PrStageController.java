package com.hrm.oa.controller;

import com.hrm.oa.entity.PrStage;
import com.hrm.oa.service.PrStageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrStage)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:44
 */
@RestController
@Slf4j
public class PrStageController {
    /**
     * 服务对象
     */
    @Resource
    private PrStageService prStageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrStage selectOne(String id) {
        return this.prStageService.queryById(id);
    }

}