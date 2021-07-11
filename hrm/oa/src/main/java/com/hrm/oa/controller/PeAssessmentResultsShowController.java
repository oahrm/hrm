package com.hrm.oa.controller;

import com.hrm.oa.entity.PeAssessmentResultsShow;
import com.hrm.oa.service.PeAssessmentResultsShowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PeAssessmentResultsShow)表控制层
 *
 * @author makejava
 * @since 2021-07-11 15:00:34
 */
@RestController
@RequestMapping("/peAssessmentResultsShow")
public class PeAssessmentResultsShowController {
    /**
     * 服务对象
     */
    @Resource
    private PeAssessmentResultsShowService peAssessmentResultsShowService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PeAssessmentResultsShow selectOne(String id) {
        return this.peAssessmentResultsShowService.queryById(id);
    }

}
