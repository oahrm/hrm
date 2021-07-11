package com.hrm.oa.controller;

import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.service.PeAssessmentIndicatorsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PeAssessmentIndicators)表控制层
 *
 * @author makejava
 * @since 2021-07-11 14:24:43
 */
@RestController
@RequestMapping("/peAssessmentIndicators")
public class PeAssessmentIndicatorsController {
    /**
     * 服务对象
     */
    @Resource
    private PeAssessmentIndicatorsService peAssessmentIndicatorsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeAssessmentIndicators selectOne(String id) {
        return this.peAssessmentIndicatorsService.queryById(id);
    }

}
