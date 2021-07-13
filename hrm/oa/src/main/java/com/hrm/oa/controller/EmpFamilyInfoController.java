package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpFamilyInfo;
import com.hrm.oa.service.EmpFamilyInfoService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpFamilyInfo)表控制层
 *
 * @author makejava
 * @since 2021-07-13 03:21:14
 */
@RestController
@RequestMapping("empFamilyInfo")
public class EmpFamilyInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmpFamilyInfoService empFamilyInfoService;

    /**
     * 查询员工的家庭成员
     */
    @GetMapping("/familyList/{empId}")
    public Result familyList(@PathVariable String empId) {
        List<EmpFamilyInfo> list = empFamilyInfoService.queryByEmpId(empId);
        return new Result(ResultCode.SUCCESS,list);
    }

}
