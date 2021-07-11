package com.hrm.oa.controller;

import com.hrm.oa.entity.Emp;
import com.hrm.oa.service.impl.EmpServiceImpl;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Bkiller
 * @Date: 2021/07/11/14:21
 * @Description:
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpServiceImpl empService;

    /**
     * 查询所有在职员工
     * @return
     */
    @GetMapping("/empList")
    public Result empList(){
        List<Emp> list = empService.findAllTheJobStatusEmpOn();
        return new Result(ResultCode.SUCCESS,list);
    }
}
