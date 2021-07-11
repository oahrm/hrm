package com.hrm.oa.controller;

import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.service.RePosimanService;
import com.hrm.oa.vo.OrganizationPageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import com.sun.org.apache.regexp.internal.REProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/recruit")
public class RePosimanController {

    @Autowired
    RePosimanService rePosimanService;

    /**
     * 查询编制管理列表
     *
     */
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    public Result importExcel(@RequestBody OrganizationPageVo organizationPageVo) throws Exception {
        if (organizationPageVo.getPage() == null) {
            organizationPageVo.setPage(1);
        }
        if (organizationPageVo.getPagesize() == null) {
            organizationPageVo.setPagesize(10);
        }
        //获取列表
        Map<String, Object> list = rePosimanService.list(organizationPageVo);
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询编制管理列表
     *
     */
    @RequestMapping(value = "add" ,method = RequestMethod.PUT)
    public Result addjihua(@RequestBody RePosimanEntity rePosimanEntity) throws Exception {
        //获取列表
        rePosimanService.save(rePosimanEntity);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询编制管理列表
     *
     */
    @RequestMapping(value = "del" ,method = RequestMethod.DELETE)
    public Result deljihua(@RequestBody RePosimanEntity rePosimanEntity) throws Exception {
        //删除
        rePosimanService.delposi(rePosimanEntity);
        return new Result(ResultCode.SUCCESS);
    }



}
