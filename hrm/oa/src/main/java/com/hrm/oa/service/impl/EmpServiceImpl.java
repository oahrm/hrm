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
     *查找所有在职员工
     * @return
     */
    @Override
    public List<Emp> findAllTheJobStatusEmpOn() {
        return empDao.selectAllByOnTheJobStatus();
    }
    /**
     *根据姓名模糊查询在职员工
     * @return
     */
    @Override
    public List<Emp> findByName(String name) {
        if(name!=null){
            name = "%"+name+"%";
        }
        return empDao.selectByName(name);
    }
}
