package com.hrm.oa.controller;

import com.hrm.oa.entity.HuPosttransfer;
import com.hrm.oa.service.HuPosttransferService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工调岗记录表(HuPosttransfer)表控制层
 *
 * @author makejava
 * @since 2021-07-13 20:11:14
 */
@RestController
@RequestMapping("huPosttransfer")
public class HuPosttransferController {
    /**
     * 服务对象
     */
    @Resource
    private HuPosttransferService huPosttransferService;

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("/postList/{empId}")
    public Result findPostByEmpId(@PathVariable String empId) {
        List<HuPosttransfer> list = huPosttransferService.queryByEmpId(empId);
        return new Result(ResultCode.SUCCESS,list);
    }

}
