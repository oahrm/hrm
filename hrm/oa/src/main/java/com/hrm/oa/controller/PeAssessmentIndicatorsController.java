package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.common.Pagination;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeAssessmentResultsShow;
import com.hrm.oa.service.PeAssessmentIndicatorsService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    IdWorker idWorker = new IdWorker();

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

    @PutMapping
    public Result updateIndicator(@RequestBody PeAssessmentIndicators peAssessmentIndicators){
        peAssessmentIndicatorsService.update(peAssessmentIndicators);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping
    public Result deleteIndicatorById(String id){
        boolean statu =  peAssessmentIndicatorsService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }

    @PostMapping("/findAllDicators")
    public Result findAllDicators(@RequestBody PeAssessmentIndicators assessmentIndicators){
        List<PeAssessmentIndicators> list =  peAssessmentIndicatorsService.queryAll(assessmentIndicators);
//        Map<String,Object> map  =new HashMap<>();
//        map.put("peAssessmentIndicators",list);
//        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,list);
    }

    @PostMapping
    public Result saveIndicators(@RequestBody PeAssessmentIndicators peAssessmentIndicators){
        peAssessmentIndicators.setIndexNumber(idWorker.nextId()+"");
        peAssessmentIndicatorsService.insert(peAssessmentIndicators);
        return new Result(ResultCode.SUCCESS);
    }

}
