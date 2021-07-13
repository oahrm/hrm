package com.hrm.oa.controller;

import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.service.HuContractoflaborService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
