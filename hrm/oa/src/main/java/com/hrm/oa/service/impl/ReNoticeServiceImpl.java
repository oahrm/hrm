package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.hrm.oa.dao.ReEntryApplicalinDao;
import com.hrm.oa.dao.ReOfferlinDao;
import com.hrm.oa.entity.ReEntryApplicalinEntity;
import com.hrm.oa.entity.ReOfferlinEntity;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.entity.RwruzhitonghiEntity;
import com.hrm.oa.service.ReNoticeService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReNoticeServiceImpl implements ReNoticeService {

    @Autowired
    ReEntryApplicalinDao reEntryApplicalinDao;

    @Autowired
    ReOfferlinDao reOfferlinDao;

    @Autowired
    IdWorker idWorker;


    @Override
    public Map<String, Object> list(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getPagesize());
        List<RePosimanEntity> list = reEntryApplicalinDao.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",list);
        map.put("tit",reEntryApplicalinDao.tit());
        return map;
    }

    @Override
    @Transactional
    public void save(RwruzhitonghiEntity reInterviewEntitytime) {
       // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //添加offer表
        ReOfferlinEntity reOfferlinEntity=new ReOfferlinEntity();
        reOfferlinEntity.setAcademicDegree(reInterviewEntitytime.getAcademicDegree());

        //到岗日期
        reOfferlinEntity.setArrivalTime(reInterviewEntitytime.getArrivalTime());
        reOfferlinEntity.setBasePay(reInterviewEntitytime.getBasePay());
        reOfferlinEntity.setDateOfBirth(reInterviewEntitytime.getDateOfBirth());
        reOfferlinEntity.setDepartment(reInterviewEntitytime.getDepartment());//部门
        reOfferlinEntity.setDivision(reInterviewEntitytime.getDivision());
        reOfferlinEntity.setOffername(reInterviewEntitytime.getOffername());
        reOfferlinEntity.setOfferId(idWorker.nextId()+"");//主键
        reOfferlinEntity.setName(reInterviewEntitytime.getName());
        reOfferlinEntity.setSex(reInterviewEntitytime.getSex());
        reOfferlinEntity.setPlace(reInterviewEntitytime.getPlace());
        reOfferlinEntity.setPhone(reInterviewEntitytime.getPhone());
        reOfferlinEntity.setIdcard(reInterviewEntitytime.getIdcard());
        reOfferlinEntity.setNation(reInterviewEntitytime.getNation());
        reOfferlinEntity.setMaritaStatus(reInterviewEntitytime.getMaritaStatus());
        reOfferlinEntity.setHighestEducation(reInterviewEntitytime.getHighestEducation());
        reOfferlinEntity.setMailbox(reInterviewEntitytime.getMailbox());
        reOfferlinEntity.setOfferStatus(reInterviewEntitytime.getOfferStatus());
        reOfferlinEntity.setDirectsuperior(reInterviewEntitytime.getDirectsuperior());
        reOfferlinEntity.setStation(reInterviewEntitytime.getStation());
        reOfferlinEntity.setOfficeLocation(reInterviewEntitytime.getOfficeLocation());
        reOfferlinEntity.setMeritPay(reInterviewEntitytime.getMeritPay());
        reOfferlinEntity.setRegularSalary(reInterviewEntitytime.getRegularSalary());
        reOfferlinEntity.setProbationPeriodSalary(reInterviewEntitytime.getProbationPeriodSalary());
        reOfferlinDao.insert(reOfferlinEntity);


        //添加入职申请表
        ReEntryApplicalinEntity entryApplicalinEntity=new ReEntryApplicalinEntity();
        entryApplicalinEntity.setId(idWorker.nextId()+"");
        entryApplicalinEntity.setTitle(reInterviewEntitytime.getTitle());
        entryApplicalinEntity.setName(reInterviewEntitytime.getName());
        entryApplicalinEntity.setIdcard(reInterviewEntitytime.getIdcard());
        entryApplicalinEntity.setOfferId(reOfferlinEntity.getOfferId());
        entryApplicalinEntity.setEntrystatus(0);
        entryApplicalinEntity.setContractstatus(0);
        entryApplicalinEntity.setJobResponsibilities(reInterviewEntitytime.getJobResponsibilities());
        reEntryApplicalinDao.insert(entryApplicalinEntity);




    }
}
