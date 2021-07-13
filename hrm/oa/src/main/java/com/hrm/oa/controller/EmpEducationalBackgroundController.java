package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpEducationalBackground;
import com.hrm.oa.service.EmpEducationalBackgroundService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学历背景表(EmpEducationalBackground)表控制层
 *
 * @author makejava
 * @since 2021-07-13 14:14:02
 */
@RestController
@RequestMapping("/edu")
public class EmpEducationalBackgroundController {
    /**
     * 服务对象
     */
    @Resource
    private EmpEducationalBackgroundService empEducationalBackgroundService;

    /**
     * 查找员工的教育背景
     */
    @GetMapping("/empEduList/{empId}")
    public Result findEmpEdu(@PathVariable String empId) {
        List<EmpEducationalBackground> empEducationalBackgrounds = empEducationalBackgroundService.queryByEduEmpId(empId);
        return new Result(ResultCode.SUCCESS,empEducationalBackgrounds);
    }
}
