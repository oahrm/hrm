package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.hrm.oa.dao.ReInterviewDao;
import com.hrm.oa.dao.ReResumeDao;
import com.hrm.oa.entity.ReInterviewEntity;
import com.hrm.oa.entity.ReInterviewEntitytime;
import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.entity.ReResumeEntity;
import com.hrm.oa.service.ReInterviewService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReInterviewServiceImpl implements ReInterviewService {
    @Autowired
    ReInterviewDao reInterviewDao;

    @Autowired
    IdWorker idWorker;

    @Autowired
    ReResumeDao reResumeDao;

    @Override
    public Map<String, Object> list(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getPagesize());
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",reInterviewDao.findAll());
        map.put("tit",reInterviewDao.tit());
        return map;
    }

    /**
     * 添加
     * @param reInterviewEntitytime
     */
    @Override
    @Transactional
    public void save(ReInterviewEntitytime reInterviewEntitytime) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ReInterviewEntity interviewEntity=new ReInterviewEntity();
        interviewEntity.setId(idWorker.nextId()+"");
        interviewEntity.setApplicationTime(new Date());
        interviewEntity.setScheduleInterviewDate(sdf.parse(reInterviewEntitytime.getScheDate()));
        interviewEntity.setResumeId(reInterviewEntitytime.getResumeId());
        interviewEntity.setUrgency("待通过");
        interviewEntity.setExplains("显示");
        interviewEntity.setInterviewForm(reInterviewEntitytime.getInterviewForm());
        interviewEntity.setInterviewStage(reInterviewEntitytime.getInterviewStage());
        interviewEntity.setJob(reInterviewEntitytime.getJob());
        interviewEntity.setPersonInCharge(reInterviewEntitytime.getPersonInCharge());
        System.out.println(interviewEntity.toString());
        reInterviewDao.insert(interviewEntity);
    }

    @Override
    /**
     * 修改
     */
    public void modifytonguo(ReInterviewEntitytime reInterviewEntitytime) {

        if(reInterviewEntitytime.getInterviewStage().equals("终试")){
            reInterviewDao.updataruyong(reInterviewEntitytime.getId());
        }
        else {
            reInterviewDao.updatetonguo(reInterviewEntitytime.getId());
        }

    }

    @Override
    public void modifyguanbi(ReInterviewEntitytime reInterviewEntitytime) {
        reInterviewDao.updataguanbi(reInterviewEntitytime.getId());
    }

    @Override
    public ReResumeEntity findjianli(String resumeId) {
        return reResumeDao.selectByPrimaryKey(resumeId);
    }
}
