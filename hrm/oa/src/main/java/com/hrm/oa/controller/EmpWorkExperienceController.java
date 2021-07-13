package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpWorkExperience;
import com.hrm.oa.service.EmpWorkExperienceService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmpWorkExperience)表控制层
 *
 * @author makejava
 * @since 2021-07-13 11:51:32
 */
@RestController
@RequestMapping("empWorkExperience")
public class EmpWorkExperienceController {
    /**
     * 服务对象
     */
    @Resource
    private EmpWorkExperienceService empWorkExperienceService;

    /**
     * 查询员工所有工作经历
     */
    @GetMapping("/workList/{empId}")
    public Result workList(@PathVariable String empId) {
        List<EmpWorkExperience> list = this.empWorkExperienceService.queryByEmpId(empId);
        return new Result(ResultCode.SUCCESS,list);
    }

}
