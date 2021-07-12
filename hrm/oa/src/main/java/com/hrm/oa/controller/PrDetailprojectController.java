package com.hrm.oa.controller;

import com.hrm.oa.entity.PrDetailproject;
import com.hrm.oa.service.PrDetailprojectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrDetailproject)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:32:45
 */
@RestController
@Slf4j
public class PrDetailprojectController {
    /**
     * 服务对象
     */
    @Resource
    private PrDetailprojectService prDetailprojectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PrDetailproject selectOne(String id) {
        return this.prDetailprojectService.queryById(id);
    }

}