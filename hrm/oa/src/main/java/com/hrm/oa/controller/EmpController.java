package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.service.impl.EmpServiceImpl;
import com.hrm.oa.vo.PageParam;
import com.hrm.oa.vo.PageResult;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Bkiller
 * @Date: 2021/07/11/14:21
 * @Description:
 */
@RestController
@CrossOrigin
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
        PageHelper pageHelper = new PageHelper();
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 模糊查询所有在职员工
     * @return
     */
    @GetMapping("/empListByName")
    public Result empListByName(@RequestBody PageParam pageParam){
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Emp> list = empService.findByName(pageParam.getKeywords());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }
}
