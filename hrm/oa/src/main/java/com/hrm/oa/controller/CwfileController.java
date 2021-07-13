package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.CwCheck;
import com.hrm.oa.entity.CwFieldPersonnel;
import com.hrm.oa.service.CwfileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CwfileController {
    @Resource
    private CwfileService cwfileService;

    @GetMapping("/selectByfile")
    public List<CwFieldPersonnel>selectByfile(){
        return cwfileService.selectByfile();
    }

    @PostMapping("/insertfile")
    public int insertfile(@RequestBody CwFieldPersonnel cwFieldPersonnel){
        return cwfileService.insertfile(cwFieldPersonnel);

    }

    @GetMapping("/findPage1")
    public PageInfo<CwFieldPersonnel> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<CwFieldPersonnel> entityPage=cwfileService.selectByfile();
        PageInfo<CwFieldPersonnel> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @GetMapping("/selectBydept")
    public PageInfo<CwFieldPersonnel> selectBydept (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<CwFieldPersonnel> entityPage=cwfileService.selectBydept(value);
        PageInfo<CwFieldPersonnel> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
