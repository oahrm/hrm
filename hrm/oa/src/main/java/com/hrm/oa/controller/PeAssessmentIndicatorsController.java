package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.service.PeAssessmentIndicatorsService;
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

    @GetMapping("/findAllDicators/{page}/{pageSize}")
    public Result findAllDicators(@PathVariable int page,@PathVariable int pageSize){
        PageInfo<PeAssessmentIndicators> pageInfo =  peAssessmentIndicatorsService.queryAll(new PeAssessmentIndicators(),page,pageSize);
        Map<String,Object> map  =new HashMap<>();
        map.put("peAssessmentIndicators",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,pageInfo);
    }

}
