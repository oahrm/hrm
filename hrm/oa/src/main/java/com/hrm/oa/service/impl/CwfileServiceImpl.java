package com.hrm.oa.service.impl;

import com.hrm.oa.dao.CwFieldPersonnelDao;
import com.hrm.oa.entity.CwFieldPersonnel;
import com.hrm.oa.service.CwfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class CwfileServiceImpl implements CwfileService {
    @Resource
    private CwFieldPersonnelDao cwFieldPersonnelDao;
    @Override
    public int insertfile(CwFieldPersonnel cwFieldPersonnel) {
        cwFieldPersonnel.setFielddate(new Date());
        cwFieldPersonnel.setFielddatetime(new Date());
        return cwFieldPersonnelDao.insertfile(cwFieldPersonnel);
    }

    @Override
    public List<CwFieldPersonnel> selectByfile() {
        return cwFieldPersonnelDao.selectByfile();
    }

    @Override
    public List<CwFieldPersonnel> selectBydept(String value) {
        return cwFieldPersonnelDao.selectBydept(value);
    }
}
