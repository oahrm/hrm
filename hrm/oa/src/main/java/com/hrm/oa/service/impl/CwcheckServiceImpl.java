package com.hrm.oa.service.impl;

import com.hrm.oa.dao.CwCheckDao;
import com.hrm.oa.entity.CwCheck;
import com.hrm.oa.service.CwcheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.Date;
import java.util.List;
@Service
public class CwcheckServiceImpl implements CwcheckService {
    @Resource
    private CwCheckDao cwCheckDao;
    @Override
    public List<CwCheck> selectBycheck() {
        return cwCheckDao.selectBycheck();
    }

    @Override
    public int insertcheck(CwCheck cwCheck) {
        cwCheck.setCheckdatatime(new Date());
        cwCheck.setCheckdata(new Date());
        cwCheck.setEmpname("张三");
        cwCheck.setDeptname("研发部");
        cwCheck.setTypelq("普通出勤");
//        Date time = new Date("08:00:00");
//
//        if(new Date("HH:mm:ss")!= time){
//            cwCheck.setTypecd("是");
//        }else {
//            cwCheck.setTypecd("否");
//        }
        return cwCheckDao.insertcheck(cwCheck);



        }

}
