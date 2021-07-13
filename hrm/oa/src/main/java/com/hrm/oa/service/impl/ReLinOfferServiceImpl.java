package com.hrm.oa.service.impl;

import com.hrm.oa.dao.ReOfferDao;
import com.hrm.oa.dao.ReOfferlinDao;
import com.hrm.oa.entity.ReOfferlinEntity;
import com.hrm.oa.service.ReLinOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReLinOfferServiceImpl implements ReLinOfferService {
    @Autowired
    ReOfferlinDao reOfferlinDao;


    @Override
    public List<ReOfferlinEntity> findAll() {
        return reOfferlinDao.findlist();
    }
}
