package com.hrm.oa.service.impl;

import com.hrm.oa.dao.HuPersonnelbecomeDao;
import com.hrm.oa.dao.ReOfferDao;
import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.entity.ReEntryApplica;
import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.ReOfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ReOfferServiceImpl implements ReOfferService {
    @Resource
    private ReOfferDao reOfferDao;
    @Resource
    private HuPersonnelbecomeDao huPersonnelbecomeDao;

    //查询出offer状态为以同意数据到劳务合同签署界面
    @Override
    public List<ReOffer> selectOffer_Hucontracto() {
        return reOfferDao.selectOffer_Hucontracto();
    }

    //将签署状态更改为1
    @Override
    public int updateOffer_Hucontracto(Integer id) {
       return reOfferDao.updateOffer_Hucontracto(id);
    }

    //查询出签署状态为以1的数据到员工入职页面
    @Override
    public List<ReOffer> selectOffer_HuPersonnelbecome() {
        return reOfferDao.selectOffer_HuPersonnelbecome();
    }
    //将入职状态更改为1
    @Override
    public int updateOffer_HuPersonnelbecome(Integer id) {
        return reOfferDao.updateOffer_HuPersonnelbecome(id);
    }




}
