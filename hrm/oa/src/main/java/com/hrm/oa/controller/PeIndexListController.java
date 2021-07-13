package com.hrm.oa.controller;

import com.hrm.oa.entity.*;
import com.hrm.oa.service.*;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 指标列表(PeIndexList)表控制层
 *
 * @author makejava
 * @since 2021-07-12 16:26:26
 */
@RestController
@RequestMapping("/peIndexList")
public class PeIndexListController {
    /**
     * 服务对象
     */
    @Resource
    private PeIndexListService peIndexListService;

    @Resource
    private PeAssessmentIndicatorsService peAssessmentIndicatorsService;

    @Resource
    private IdWorker idWorker;

    @Resource
    private EmpService empService;

    @Resource
    private PeExamineGradeService peExamineGradeService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeIndexList selectOne(String indexId) {
        return this.peIndexListService.queryById(indexId);
    }

    @PostMapping("/findAll")
    public Result findAllIndexList(@RequestBody PeIndexList peIndexList){
        System.out.println("查询考核指标项");
        System.out.println(peIndexList.getEmpId());
        List<PeIndexList> lists = peIndexListService.queryAllIndexList(peIndexList);
        return new Result(ResultCode.SUCCESS,lists);
    }

    @PostMapping("/findAllIndexList")
    public Result findAllIndexList(@RequestBody Emp emp){
        List<PeAssessmentIndicators> peAssessmentIndicatorsList = null;
            PeAssessmentIndicators peAssessmentIndicators = new PeAssessmentIndicators();
            peAssessmentIndicators.setDeptId(emp.getDeptId());
            peAssessmentIndicatorsList =  peAssessmentIndicatorsService.queryAll(peAssessmentIndicators);
        List<PeIndexList> peIndexListList = new ArrayList<>();
        if(peAssessmentIndicatorsList!=null){

            for (PeAssessmentIndicators peAssessmentIndicator : peAssessmentIndicatorsList) {

                PeIndexList peIndexListTwo  = new PeIndexList();
                peIndexListTwo.setIndexId(idWorker.nextId()+"");
                peIndexListTwo.setEmpId(emp.getEmpId());
                peIndexListTwo.setType(peAssessmentIndicator.getType());
                peIndexListTwo.setIndicatorDescription(peAssessmentIndicator.getIndicatorDescription());
                peIndexListTwo.setNameOfIndex(peAssessmentIndicator.getIndexNumber());
                peIndexListTwo.setWeight(peAssessmentIndicator.getWeight());
                peIndexListTwo.setInitiateMode(1);
                peIndexListList.add(peIndexListTwo);

            }
        }
        return new Result(ResultCode.SUCCESS,peIndexListList);
    }

    @PostMapping("/addIndexList")
    public Result addIndexList(@RequestBody List<PeIndexList> indexList){
        PeExamineGrade peExamineGrade = new PeExamineGrade();
        peExamineGrade.setScoreId(idWorker.nextId()+"");
        peExamineGrade.setPerformanceScoringObject(indexList.get(0).getEmpId());
        for (PeIndexList peIndexList : indexList) {
            peIndexList.setIndexId(idWorker.nextId()+"");
            int i =  peIndexListService.insert(peIndexList);
        }
        return new Result(ResultCode.SUCCESS);


    }
}
