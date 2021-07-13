package com.hrm.oa.controller;

import com.hrm.oa.entity.PrProject;
import com.hrm.oa.service.PrProjectService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PrProject)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:18
 */
@RestController
@Slf4j
@RequestMapping("pro")
public class PrProjectController {
    /**
     * 服务对象
     */
    @Autowired
    private PrProjectService prProjectService;
    @Autowired
    private IdWorker idWorker;

    @PostMapping("/insertpr_project")
    public Result insertpr_project(@RequestBody PrProject prProject) {
        prProject.setPId(idWorker.nextId()+"");
        PrProject prProjectNew=prProjectService.insertpr_project(prProject);
        return new Result(ResultCode.SUCCESS,prProjectNew);
    }

}