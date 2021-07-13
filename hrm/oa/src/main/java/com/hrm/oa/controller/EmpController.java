package com.hrm.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.impl.EmpServiceImpl;
import com.hrm.oa.vo.PageParam;
import com.hrm.oa.vo.PageResult;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        List<Emp> list = empService.findByName(pageParam.getEmp());
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(),list);
        return new Result(ResultCode.SUCCESS,pageResult);
    }

    //员工入职将offer表数据新增到emp表
    @PostMapping("/AddEmpOffer")
    public Emp insert(@RequestBody Emp emp){
        log.debug(emp.toString());
        emp=empService.insertEmp_ReOffer(emp);
        return emp;
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
     *查找下属
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


    //查询员工表为实习期的员工到转正页面
    @GetMapping("/findEmpOersZz")
    public Result findEmpOersZz(){
        log.debug("查询员工表为实习期的员工到转正页面");
        List<Emp> EmpOersZz=empService.findEmpOersZz();
        return new Result(ResultCode.SUCCESS,EmpOersZz);
    }

    //查询员工表已转正的员工到已转正页面
    @GetMapping("/findEmpOersYZz")
    public Result findEmpOersYZz(){
        log.debug("查询员工表已转正的员工到已转正页面");
        List<Emp> EmpOersYZz=empService.findEmpOersYZz();
        return new Result(ResultCode.SUCCESS,EmpOersYZz);
    }

    //查询未离职员工
    @GetMapping("/findEmpHuLiZhi")
    public Result findEmpHuLiZhi(){
        log.debug("查询已离职员工");
        List<Emp> EmpOersLIZhi=empService.selectEmpHuLiZhi();
        return new Result(ResultCode.SUCCESS,EmpOersLIZhi);
    }

    //查询已离职员工
    @GetMapping("/findEmpHuYLiZhi")
    public Result findEmpHuYLiZhi(){
        log.debug("查询已离职员工");
        List<Emp> EmpOersYLIZhi=empService.selectEmpHuYLiZhi();
        return new Result(ResultCode.SUCCESS,EmpOersYLIZhi);
    }



    //将转正状态更改为1
    @PutMapping("/updateEmpOersZz/{empId}")
    public int updateEmpOersZz(@PathVariable("empId") String empId){
        return  empService.updateEmpOersZz(empId);
    }

    //将转正状态更改为1
    @PutMapping("/updateEmp_HuPosttransfer/{empId}")
    public int updateEmp_HuPosttransfer(@PathVariable("empId") String empId){
        return  empService.updateEmp_HuPosttransfer(empId);
    }


    @PutMapping("/updateEmp_HuLiZhi/{empId}")
    public int updateEmp_HuLiZhi(@PathVariable("empId") String empId){
        return  empService.updateEmp_HuLiZhi(empId);
    }


    //未调岗人员查询
    @GetMapping("/findEmpOersWdg")
    public Result findEmpOersWdg(){
        log.debug("查询员工表已转正的员工到已转正页面");
        List<Emp> EmpOersWdg=empService.findEmpOersWdg();
        return new Result(ResultCode.SUCCESS,EmpOersWdg);
    }

    //未调岗人员查询
    @GetMapping("/findEmpOersYdg")
    public Result findEmpOersYdg(){
        log.debug("查询员工表已转正的员工到已转正页面");
        List<Emp> EmpOersYdg=empService.findEmpOersYdg();
        return new Result(ResultCode.SUCCESS,EmpOersYdg);
    }

    @PutMapping("/updateEmp_Deptname/{empId}")
    public Result updateEmp_Deptname(@PathVariable("empId") String empId){
        empService.updateEmp_Deptname(empId);
        return new Result(ResultCode.SUCCESS);
    }



    /**
     *根据员工id查找员工
     * @return
     */
    @GetMapping("/findEmp/{empId}")
    public Result findByEmpId(@PathVariable String empId) {
        Emp emp = empService.findEmpByEmpId(empId);
        return new Result(ResultCode.SUCCESS, emp);
    }

    /**
     * 统计员工下属个数
     */
    @GetMapping("/empCount/{empId}")
    public Result empCount(@PathVariable String empId) {
        int i = empService.countEmpByParentId(empId);
        return new Result(ResultCode.SUCCESS, i);
    }

    /**
     * 修改员工
     */
    @PutMapping("/updateEmp")
    public Result updateEmp(@RequestBody Emp emp) {
        empService.updateEmpByEmpId(emp);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据部门查询员工
     */
    @PostMapping("/findEmpsByDeptId")
    public Result findEmpsByDeptId(@RequestBody Emp emp){
        List<Emp> emps = empService.selectAllByDeptId(emp.getDeptId());
        return  new Result(ResultCode.SUCCESS,emps);
    }
}
