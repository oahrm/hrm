package com.hrm.oa.service.impl;

import com.hrm.oa.dao.ReOfferDao;
import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.ReOfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReOfferServiceImpl implements ReOfferService {
    @Autowired
    private ReOfferDao reOfferDao;
    @Override
    //查询出offer状态为以同意数据到劳务合同签署界面
    public List<ReOffer> selectOffer_Hucontracto() {
        return reOfferDao.selectOffer_Hucontracto();
    }
}
