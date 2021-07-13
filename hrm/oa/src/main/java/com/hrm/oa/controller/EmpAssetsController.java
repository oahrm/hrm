package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpAssets;
import com.hrm.oa.service.EmpAssetsService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpAssets)表控制层
 *
 * @author makejava
 * @since 2021-07-12 22:06:12
 */
@RestController
@RequestMapping("ass")
public class EmpAssetsController {
    /**
     * 服务对象
     */
    @Resource
    private EmpAssetsService empAssetsService;

    /**
     * 查询某个员工的所有资产
     */
    @GetMapping("findByEmpId/{empId}")
    public Result findByEmpId(@PathVariable String empId) {
        List<EmpAssets> list = empAssetsService.findAssetsByEmpId(empId);
        return new Result(ResultCode.SUCCESS,list);
    }

}
