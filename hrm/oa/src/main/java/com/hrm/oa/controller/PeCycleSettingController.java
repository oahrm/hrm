package com.hrm.oa.controller;

import com.hrm.oa.entity.PeCycleSetting;
import com.hrm.oa.service.PeCycleSettingService;
import com.hrm.oa.util.IdWorker;
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

    



}
