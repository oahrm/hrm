package com.hrm.oa.controller;

import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.service.RePosimanService;
import com.hrm.oa.vo.OrganizationPageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import com.sun.org.apache.regexp.internal.REProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<RePosimanEntity> list=rePosimanService.list();

        return new Result(ResultCode.SUCCESS,list);
    }

}
