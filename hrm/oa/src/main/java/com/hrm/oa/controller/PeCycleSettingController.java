package com.hrm.oa.controller;

import com.hrm.oa.entity.PeAssessmentSetting;
import com.hrm.oa.entity.PeCycleSetting;
import com.hrm.oa.service.PeCycleSettingService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PeCycleSetting)表控制层
 *
 * @author makejava
 * @since 2021-07-11 16:44:05
 */
@RestController
@RequestMapping("/peCycleSetting")
public class PeCycleSettingController {
    /**
     * 服务对象
     */
    @Resource
    private PeCycleSettingService peCycleSettingService;

    IdWorker idWorker = new IdWorker();

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeCycleSetting selectOne(String id) {
        return this.peCycleSettingService.queryById(id);
    }

    @PostMapping("/addCycleSetting")
    public int addCycleSetting(@RequestBody PeCycleSetting peCycleSetting){

        peCycleSetting.setCycleSettingNumber(String.valueOf(idWorker.toString()));

        int i = peCycleSettingService.insert(peCycleSetting);

        return i;
    }

    @PutMapping
    public Result updateSetting(@RequestBody PeCycleSetting peCycleSetting){
        peCycleSettingService.update(peCycleSetting);
        return new Result(ResultCode.SUCCESS);
    }

//    @PostMapping("/addCycleSetting")
//    public Result addSetting(@RequestBody PeCycleSetting peCycleSetting) {
//        peCycleSetting.setCycleSettingNumber(idWorker.nextId()+"");
//        peCycleSettingService.insert(peCycleSetting);
//        return new Result(ResultCode.SUCCESS);
//    }

    @DeleteMapping
    public Result deleteSecitonById(String id){
        boolean statu =  peCycleSettingService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }

    



}
