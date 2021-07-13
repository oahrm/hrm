package com.hrm.oa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.PrStage;
import com.hrm.oa.service.PrStageService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrStage)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:44
 */
@RestController
@Slf4j
public class PrStageController {

    @Autowired
    private PrStageService prStageService;
    @Autowired
    private IdWorker idWorker;

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestBody String sid){
        PrStage prStage=prStageService.deleteById(sid);
        return new Result(ResultCode.SUCCESS,prStage);
    }

    @PostMapping("/insertprstage")
    public Result insertCourse(@RequestBody Object obj){
//        ObjectMapper objectMapper=new ObjectMapper();
//        PrStage prStage=
//                objectMapper.convertValue(obj, PrStage.class);
        PrStage prStage=new PrStage();
//        obj = redisUtil.get(userInfoJSON.get("openId").toString());
//        PrStage prStage = new ObjectMapper().convertValue(obj, PrStage.class);
        log.debug(obj.toString());
        log.debug(prStage.toString());
//        prStage.setSId(idWorker.nextId()+"");
//        PrStage prStageNew=prStageService.insertpr_stage(prStage);
//        return new Result(ResultCode.SUCCESS,prStageNew);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/selectAllpr_stageInfo")
    public Result selectAllpr_stageInfo(@RequestParam("currentPage") int currentPage,
                                                @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<PrStage> entityPage =prStageService.selectAllpr_stage();
        PageInfo<PrStage> prStagePageInfo = new  PageInfo<>(entityPage);
        return new Result(ResultCode.SUCCESS,prStagePageInfo);
    }

    @GetMapping("/selectAllprstage")
    public Result selectAllpr_stage(){
        System.out.println("测试");
        List<PrStage> entityPage =prStageService.selectAllpr_stage();
        return new Result(ResultCode.SUCCESS,entityPage);
    }
}