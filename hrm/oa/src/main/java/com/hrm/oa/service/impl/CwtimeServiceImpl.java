package com.hrm.oa.service.impl;

import com.hrm.oa.dao.CwTimeDao;
import com.hrm.oa.entity.CwTime;
import com.hrm.oa.service.CwtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CwtimeServiceImpl implements CwtimeService {
    @Resource
    @Autowired
    private CwTimeDao cwTimeDao;
    @Override
    public List<CwTime> selectBytime() {
        return cwTimeDao.selectBytime();
    }
}
