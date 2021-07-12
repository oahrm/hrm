package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeAssessmentResultsShow;
import com.hrm.oa.service.PeAssessmentResultsShowService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    IdWorker idWorker = new IdWorker();
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeAssessmentResultsShow selectOne(String id) {
        return this.peAssessmentResultsShowService.queryById(id);
    }

    @PostMapping
    public Result saveResultShow(@RequestBody PeAssessmentResultsShow peAssessmentResultsShow){
        peAssessmentResultsShow.setResultId(idWorker.nextId()+"");
        peAssessmentResultsShowService.insert(peAssessmentResultsShow);
        return new Result(ResultCode.SUCCESS);
    }

    @PutMapping
    public Result updateResultShow(@RequestBody PeAssessmentResultsShow peAssessmentResultsShow){
        peAssessmentResultsShowService.update(peAssessmentResultsShow);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping
    public Result deleteResultShowById(String id){
        boolean statu =  peAssessmentResultsShowService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }

    @GetMapping("/findAll/{page}/{pageNum}")
    public Result selectAllResultShow(@PathVariable int page,@PathVariable int pageSize){
        PageInfo<PeAssessmentResultsShow> pageInfo =  peAssessmentResultsShowService.queryAll(new PeAssessmentResultsShow(),page,pageSize);
        Map<String,Object> map  =new HashMap<>();
        map.put("peAssessmentResultsShow",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,pageInfo);
    }


}
