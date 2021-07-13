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
        emp.setDeptId("3");
        emp.setRanks(3);
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
        emp.setParentId("3");
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

    @Override
    public List<Emp> selectAllByDeptId(String deptId) {
        return empDao.selectAllByDeptId(deptId);
    }
}
