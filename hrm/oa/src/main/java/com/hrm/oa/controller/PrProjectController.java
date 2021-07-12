package com.hrm.oa.controller;

import com.hrm.oa.entity.PrProject;
import com.hrm.oa.service.PrProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrProject)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:18
 */
@RestController
@Slf4j
public class PrProjectController {
    /**
     * 服务对象
     */
    @Resource
    private PrProjectService prProjectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrProject selectOne(String id) {
        return this.prProjectService.queryById(id);
    }

}