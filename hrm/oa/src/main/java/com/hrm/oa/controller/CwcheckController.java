package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.CwCheck;
import com.hrm.oa.service.CwcheckService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CwcheckController {
    @Resource
    private CwcheckService cwcheckService;
    @GetMapping("/selectBycheck")
    public List<CwCheck>selectBycheck(){
        return cwcheckService.selectBycheck();
    }

    @PostMapping("/insertcheck")
    public int insertcheck(@RequestBody CwCheck cwCheck){
       return cwcheckService.insertcheck(cwCheck);

    }

    @GetMapping("/findPage")
    public PageInfo<CwCheck> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<CwCheck> entityPage=cwcheckService.selectBycheck();
        PageInfo<CwCheck> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
