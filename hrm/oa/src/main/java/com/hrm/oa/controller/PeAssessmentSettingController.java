package com.hrm.oa.controller;

import com.hrm.oa.entity.PeAssessmentSection;
import com.hrm.oa.entity.PeAssessmentSetting;
import com.hrm.oa.service.PeAssessmentSettingService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 考核设置表(PeAssessmentSetting)表控制层
 *
 * @author makejava
 * @since 2021-07-12 00:53:03
 */
@RestController
@RequestMapping("/peAssessmentSetting")
public class PeAssessmentSettingController {
    /**
     * 服务对象
     */
    @Resource
    private PeAssessmentSettingService peAssessmentSettingService;


    IdWorker idWorker = new IdWorker();
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeAssessmentSetting selectOne(String id) {
        return this.peAssessmentSettingService.queryById(id);
    }

    @PutMapping
    public Result updateSetting(@RequestBody PeAssessmentSetting peAssessmentSetting){
        peAssessmentSettingService.update(peAssessmentSetting);
        return new Result(ResultCode.SUCCESS);
    }

    @PostMapping("/addSetting")
    public Result addSetting(@RequestBody PeAssessmentSetting peAssessmentSetting) {
        peAssessmentSetting.setAssSettingId(idWorker.nextId()+"");
        peAssessmentSettingService.insert(peAssessmentSetting);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping
    public Result deleteSecitonById(String id){
        boolean statu =  peAssessmentSettingService.deleteById(id);
        return new Result(ResultCode.SUCCESS,statu);
    }

}
