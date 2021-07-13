package com.hrm.oa.service.impl;

import com.hrm.oa.dao.EmpDao;
import com.hrm.oa.entity.Emp;
import com.hrm.oa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    /**
     *根据姓名模糊查询在职员工
     * @return
     */
    @Override
    public List<Emp> findByName(String name) {
        if(name!=null){
            name = "%"+name.trim()+"%";
        }
        return empDao.selectByName(name);
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


}
