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
     * 模糊查询所有在职员工
     * @return
     */
    @PostMapping("/empListByName")
    public Result empListByName(@RequestBody PageParam pageParam){
        PageHelper.startPage(Integer.parseInt(pageParam.getPage()), Integer.parseInt(pageParam.getSize()));
        List<Emp> list = empService.findByName(pageParam.getEmp().getName());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }

    /**
     *查找部门下与自己同级的员工
     * @return
     */
    @PostMapping("/findByDeptAndRanks")
    public Result findEmpByDeptIdAndRanks(@RequestBody PageParam pageParam) {
        PageHelper.startPage(Integer.parseInt(pageParam.getPage()), Integer.parseInt(pageParam.getSize()));
        List<Emp> list = empService.findEmpByDeptIdAndRanks(pageParam.getEmp());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }
    /**
     *查找部门下与自己同级的员工
     * @return
     */
    @PostMapping("/findByParentId")
    public Result findByParentId(@RequestBody PageParam pageParam) {
        PageHelper.startPage(Integer.parseInt(pageParam.getPage()), Integer.parseInt(pageParam.getSize()));
        List<Emp> list = empService.findEmpByParenId(pageParam.getEmp());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(), list);
        return new Result(ResultCode.SUCCESS, pageResult);
    }

    @PostMapping("/findEmpsByDeptId")
    public Result findEmpsByDeptId(@RequestBody Emp emp){
        List<Emp> emps = empService.selectAllByDeptId(emp.getDeptId());
        return  new Result(ResultCode.SUCCESS,emps);
    }
}
