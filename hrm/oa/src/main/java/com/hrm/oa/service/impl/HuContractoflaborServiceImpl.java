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
import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance(); //创建Calendar 的实例
        Date date = new Date();//获取当前时间
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,+3);
//返回当前时间的毫秒数
        calendar.getTime();
        huContractoflabor.setJssignerTime(calendar.getTime());
        huContractoflabor.setContractName(huContractoflabor.getSignerName()+"的劳务合同");
        huContractoflabor.setContract("劳务合同");
////类似的
////当前时间减去一个月
//        calendar.add(Calendar.MONTH, -1);
////当前时间减去一天
//        calendar.add(Calendar.DATE, -1);

        huContractoflaborDao.insert(huContractoflabor);
        return huContractoflabor;
    }

    @Override
    public HuContractoflabor findContractoflaborById(String contractId) {
        return huContractoflaborDao.selectByPrimaryKey(contractId);
    }
}
