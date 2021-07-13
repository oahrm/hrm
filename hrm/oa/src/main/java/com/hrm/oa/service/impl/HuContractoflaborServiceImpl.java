package com.hrm.oa.service.impl;

import com.hrm.oa.dao.HuContractoflaborDao;
import com.hrm.oa.dao.HuPersonnelbecomeDao;
import com.hrm.oa.entity.HuContractoflabor;
import com.hrm.oa.service.HuContractoflaborService;
import com.hrm.oa.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class HuContractoflaborServiceImpl implements HuContractoflaborService {
    @Resource
    private HuContractoflaborDao huContractoflaborDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public HuContractoflabor insertHuContractoflabor(HuContractoflabor huContractoflabor) {
        huContractoflabor.setContractId(idWorker.nextId()+"");
        huContractoflabor.setSignerTime(new Date());
        huContractoflaborDao.insert(huContractoflabor);
        return huContractoflabor;
    }
}
