package com.hrm.oa.controller;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeExamineGrade;
import com.hrm.oa.service.PeExamineGradeService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PeExamineGrade)表控制层
 *
 * @author makejava
 * @since 2021-07-11 16:23:59
 */
@RestController
@RequestMapping("/peExamineGrade")
public class PeExamineGradeController {
    /**
     * 服务对象
     */
    @Resource
    private PeExamineGradeService peExamineGradeService;

    IdWorker idWorker = new IdWorker();

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeExamineGrade selectOne(String id) {
        return this.peExamineGradeService.queryById(id);
    }


    @GetMapping("/findAllDicators/{page}/{pageSize}")
    public Result findAllGrades(@PathVariable int page,@PathVariable int pageSize){
        PageInfo<PeExamineGrade> pageInfo =  peExamineGradeService.queryAll(new PeExamineGrade(),page,pageSize);
        Map<String,Object> map  =new HashMap<>();
        map.put("peAssessmentIndicators",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,pageInfo);
    }

    @PostMapping
    public Result addExamineGrades(@RequestBody PeExamineGrade peExamineGrade){
        peExamineGrade.setScoreId(String.valueOf(idWorker.nextId()));
        int i = peExamineGradeService.insert(peExamineGrade);
        return new Result(ResultCode.SUCCESS,i);
    }



}
