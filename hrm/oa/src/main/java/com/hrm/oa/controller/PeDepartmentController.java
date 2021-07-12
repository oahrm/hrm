package com.hrm.oa.controller;

import com.hrm.oa.entity.PeDepartment;
import com.hrm.oa.service.PeDepartmentService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PeDepartment)表控制层
 *
 * @author makejava
 * @since 2021-07-11 21:02:08
 */
@RestController
@RequestMapping("dept")
public class PeDepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private PeDepartmentService peDepartmentService;

    /**
     * 查找所有部门
     *
     * @return 集合
     */
    @GetMapping("deptList")
    public Result selectOne() {
        List<PeDepartment> list = this.peDepartmentService.findAllDept();
        return new Result(ResultCode.SUCCESS,list);
    }


}
