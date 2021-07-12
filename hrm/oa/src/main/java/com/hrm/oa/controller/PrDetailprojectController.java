package com.hrm.oa.controller;

import com.hrm.oa.entity.PrDetailproject;
import com.hrm.oa.entity.PrTask;
import com.hrm.oa.service.PrDetailprojectService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PrDetailproject)表控制层
 *
 * @author makejava
 * @since 2021-07-11 20:32:45
 */
@RestController
@Slf4j
public class PrDetailprojectController {
    /**
     * 服务对象
     */
    @Autowired
    private PrDetailprojectService prDetailprojectService;
    @Autowired
    private IdWorker idWorker;

    @PostMapping("/insertpr_task")
    public Result insertpr_task(@RequestBody List<String> biglist){
        PrDetailproject prDetailproject=new PrDetailproject();
        prDetailproject.setDId(idWorker.nextId()+"");
        prDetailproject.setPId(biglist.get(0));
        prDetailproject.setTId(biglist.get(1));
        PrDetailproject prDetailprojectNew=prDetailprojectService.insertpr_detailproject(prDetailproject);
        return new Result(ResultCode.SUCCESS,prDetailprojectNew);
    }


}