package com.hrm.oa.service.impl;

import com.hrm.oa.dao.EmpDao;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.EmpService;
import com.hrm.oa.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private EmpDao empDao;
    /**
     *根据姓名模糊查询在职员工
     * @return
     */
    @Override
    public List<Emp> findByName(Emp emp) {
        if(emp.getName()!=null){
            emp.setName("%"+emp.getName().trim()+"%");
        }
        return empDao.selectByName(emp);
    }

    //员工入职将offer表数据新增到emp表
    @Override
    public Emp insertEmp_ReOffer(Emp emp) {
        emp.setEmpId(idWorker.nextId()+"");

        emp.setPassword("123456");
        emp.setRanks(3);
        emp.setIsItOnline(0);
        emp.setJobDescription("0");
        empDao.insertEmp_ReOffer(emp);
        return emp;
    }


    /**
     *查找部门下与自己同级的员工
     * @return
     */
    @Override
    public List<Emp> findEmpByDeptIdAndRanks(Emp emp) {
        Emp emp1 = empDao.selectByPrimaryKey(emp.getEmpId());
        emp.setDeptId(emp1.getDeptId());
        emp.setRanks(emp1.getRanks());
        if(emp.getName()!=null){
            emp.setName("%"+emp.getName().trim()+"%");
        }
        return empDao.selectByDeptIdAndRanks(emp);
    }

    /**
     *查找下级下属
     * @return
     */
    @Override
    public List<Emp> findEmpByParenId(Emp emp) {
        emp.setParentId(emp.getEmpId());
        if(emp.getName()!=null){
            emp.setName("%"+emp.getName().trim()+"%");
        }
        return empDao.selectEmpByParenId(emp);
    }

    /**
     * 查询所有在职员工
     * @return
     */
    @Override
    public List<Emp> findAllEmp() {
        return empDao.selectByOnTheJobStatus();
    }

    //查询员工表为实习期的员工到转正页面
    @Override
    public List<Emp> findEmpOersZz() {
        return empDao.selectEmpOersZz();
    }

    //查询员工表已转正的员工到已转正页面
    @Override
    public List<Emp> findEmpOersYZz() {
        return empDao.selectEmpOersYZz();
    }

    //将转正状态更改为1
    @Override
    public int updateEmpOersZz(String empId) {

        return empDao.updateEmpOersZz(empId);
    }

    /**
     * 查询某个员工
     * @param empId
     * @return
     */
    @Override
    public Emp findEmpByEmpId(String empId) {
        return empDao.selectByPrimaryKey(empId);
    }

    /**
     * 统计某个员工的直接下属数量
     * @param empId
     * @return
     */
    @Override
    public Integer countEmpByParentId(String empId) {
        return empDao.empCount(empId);
    }

    /**
     * 通过员工id修改员工信信息
     * @return
     */
    @Override
    public int updateEmpByEmpId(Emp emp) {
        return empDao.updateByPrimaryKey(emp);
    }

    /**
     * 根据部门查询员工
     * @param deptId
     * @return
     */
    @Override
    public List<Emp> selectAllByDeptId(String deptId) {
        return empDao.selectAllByDeptId(deptId);
    }


}
