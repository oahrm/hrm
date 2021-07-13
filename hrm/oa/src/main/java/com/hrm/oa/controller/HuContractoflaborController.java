package com.hrm.oa.controller;

import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.service.HuContractoflaborService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HuContractoflaborController {
    @Autowired
    private HuContractoflaborService huContractoflaborService;
    //新增
    @PostMapping("/AddHuContractoflabor")
    public HuContractoflabor insert(@RequestBody HuContractoflabor huContractoflabor){
        log.debug(huContractoflabor.toString());
        huContractoflabor=huContractoflaborService.insertHuContractoflabor(huContractoflabor);
        return huContractoflabor;
    }
    /**
     *查询合同
     */
    @GetMapping("/contractoflabor/{contractId}")
    public Result findContractoflabor(@PathVariable String contractId){
        HuContractoflabor contractoflabor = huContractoflaborService.findContractoflaborById(contractId);
        return new Result(ResultCode.SUCCESS,contractoflabor);
    }
}
