package com.hrm.oa.controller;

import com.github.pagehelper.PageInfo;
import com.hrm.oa.common.Pagination;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.entity.PeAssessmentIndicators;
import com.hrm.oa.entity.PeCycleSetting;
import com.hrm.oa.entity.PeExamineGrade;
import com.hrm.oa.service.PeAssessmentIndicatorsService;
import com.hrm.oa.service.PeExamineGradeService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
     * @param
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public PeExamineGrade selectOne(@PathVariable String id) {
        return this.peExamineGradeService.queryById(id);
    }


    @PostMapping("/findAllDicators")
    public Result findAllGrades(@RequestBody Pagination pagination){
        PageInfo<PeExamineGrade> pageInfo =  peExamineGradeService.queryAll(new PeExamineGrade(),pagination.getPage(),pagination.getPageSize());
        Map<String,Object> map  =new HashMap<>();
        map.put("peAssessmentIndicators",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return new Result(ResultCode.SUCCESS,pageInfo);
    }

    @PostMapping("/examineGrade")
    public Result addExamineGrades(@RequestBody PeExamineGrade peExamineGrade){
        System.out.println("进入了这个地方");
        peExamineGrade.setScoreId(String.valueOf(idWorker.nextId()));
        peExamineGrade.setScoreDate(new Date());
        int i = peExamineGradeService.insert(peExamineGrade);
        return new Result(ResultCode.SUCCESS,peExamineGrade.getScoreId());
    }

    @PutMapping
    public Result updateSetting(@RequestBody PeExamineGrade peExamineGrade){
        peExamineGradeService.update(peExamineGrade);
        return new Result(ResultCode.SUCCESS);
    }


    @DeleteMapping("/{id}")
    public Result deleteSecitonById(@PathVariable String id){
        System.out.println("进入了删除方法");
        boolean statu =  peExamineGradeService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }





}
