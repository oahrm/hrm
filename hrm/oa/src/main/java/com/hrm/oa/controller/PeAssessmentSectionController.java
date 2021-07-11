package com.hrm.oa.controller;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentResultsShow;
import com.hrm.oa.entity.PeAssessmentSection;
import com.hrm.oa.service.PeAssessmentSectionService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/findAll/{page}/{pageNum}")
    public Result selectAllResultShow(@PathVariable int page,@PathVariable int pageSize){
        PageInfo<PeAssessmentSection> pageInfo =  peAssessmentSectionService.queryAll(new PeAssessmentSection(),page,pageSize);
        Map<String,Object> map  =new HashMap<>();
        map.put("peAssessmentSection",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,pageInfo);
    }

    @PutMapping
    public Result updateSeciton(@RequestBody PeAssessmentSection peAssessmentSection){
        peAssessmentSectionService.update(peAssessmentSection);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping
    public Result deleteSecitonById(String id){
        boolean statu =  peAssessmentSectionService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }



}
