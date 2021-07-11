package com.hrm.oa.controller;

import com.hrm.oa.entity.PeAssessmentSection;
import com.hrm.oa.service.PeAssessmentSectionService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PeAssessmentSection)表控制层
 *
 * @author makejava
 * @since 2021-07-11 15:15:51
 */
@RestController
@RequestMapping("/peAssessmentSection")
public class PeAssessmentSectionController {
    /**
     * 服务对象
     */
    @Resource
    private PeAssessmentSectionService peAssessmentSectionService;

    IdWorker idWorker = new IdWorker();
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeAssessmentSection selectOne(String id) {
        return this.peAssessmentSectionService.queryById(id);
    }

    @PostMapping("/addSeciton")
    public Result addSeciton(@RequestBody PeAssessmentSection peAssessmentSection) {
        peAssessmentSection.setScoreId(String.valueOf(idWorker.nextId()));
        peAssessmentSectionService.insert(peAssessmentSection);
        return new Result(ResultCode.SUCCESS);
    }

}
