package com.hrm.oa.controller;

import com.hrm.oa.entity.PrTask;
import com.hrm.oa.service.PrTaskService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (PrTask)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:33:52
 */
@RestController
@Slf4j
@CrossOrigin
public class PrTaskController {
    /**
     * 服务对象
     */
    @Autowired
    private PrTaskService prTaskService;
    @Autowired
    private IdWorker idWorker;

    @PostMapping("/insertpr_task")
    public Result insertpr_task(@RequestBody PrTask prTask){
        prTask.setTId(idWorker.nextId()+"");
        PrTask prTaskNew=prTaskService.insertpr_task(prTask);
        return new Result(ResultCode.SUCCESS,prTaskNew);
    }



}