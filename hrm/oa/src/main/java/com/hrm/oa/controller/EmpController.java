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
    @PostMapping("/empList")
    public Result empList(@RequestBody PageParam pageParam){
        PageHelper.startPage(Integer.parseInt(pageParam.getPage()), Integer.parseInt(pageParam.getSize()));
        List<Emp> list = empService.findAllTheJobStatusEmpOn();
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }

    /**
     * 模糊查询所有在职员工
     * @return
     */
    @PostMapping("/empListByName")
    public Result empListByName(@RequestBody PageParam pageParam){
        PageHelper.startPage(Integer.parseInt(pageParam.getPage()), Integer.parseInt(pageParam.getSize()));
        List<Emp> list = empService.findByName(pageParam.getKeywords());
        System.out.println(list.toString());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }

    /**
     * 模糊查询所有在职员工
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Emp> list = empService.findAllTheJobStatusEmpOn();
        return new Result(ResultCode.SUCCESS,list);
    }
}
