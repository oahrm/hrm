package com.hrm.oa.controller;

import com.hrm.oa.entity.CwTime;
import com.hrm.oa.service.CwtimeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CwtimeController {

    @Autowired
    private CwtimeService cwtimeService;

    @GetMapping("/selectBytime")
    public List<CwTime> selectBytime(){
        return cwtimeService.selectBytime();
    }
}
