package com.hrm.oa.service.impl;

import com.hrm.oa.dao.RePosimanDao;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.service.RePosimanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RePosimanServiceImpl implements RePosimanService {
    @Autowired
    protected RePosimanDao reposimanDao;

    @Override
    public List<RePosimanEntity> list() {
        return reposimanDao.findAll();
    }

    @Override
    public void save(RePosimanEntity rePosimanEntity) {


    }
}
