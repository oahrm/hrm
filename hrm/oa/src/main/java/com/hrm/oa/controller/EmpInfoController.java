package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpInfo;
import com.hrm.oa.service.EmpInfoService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 员工个人信息表(EmpInfo)表控制层
 *
 * @author makejava
 * @since 2021-07-13 00:43:47
 */
@RestController
@RequestMapping("empInfo")
public class EmpInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmpInfoService empInfoService;

    /**
     * 通过主键查询单条数据
     *
     */
    @GetMapping("/selectOne/{empId}")
    public Result selectOne(@PathVariable String empId) {
        EmpInfo empInfo = this.empInfoService.queryById(empId);
        return new Result(ResultCode.SUCCESS,empInfo);
    }

}
