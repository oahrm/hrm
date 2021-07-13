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
        List<ReInterviewEntity> list = reInterviewDao.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",list);

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
        //添加简历表
        ReResumeEntity reResumeEntity=new ReResumeEntity(reInterviewEntitytime);
        reResumeEntity.setResumeId(idWorker.nextId()+"");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //添加生日
        reResumeEntity.setBirthday(sdf.parse(reInterviewEntitytime.getBirthday()));
        reResumeDao.insert(reResumeEntity);

        ReInterviewEntity interviewEntity=new ReInterviewEntity(reInterviewEntitytime);
        interviewEntity.setId(idWorker.nextId()+"");
        interviewEntity.setApplicationTime(sdf.parse(reInterviewEntitytime.getAppTime()));
        interviewEntity.setScheduleInterviewDate(sdf.parse(reInterviewEntitytime.getScheDate()));
        interviewEntity.setResumeId(reResumeEntity.getResumeId());
        reInterviewDao.insert(interviewEntity);
    }

    @Override
    /**
     * 修改
     */
    public void modifytonguo(ReInterviewEntitytime reInterviewEntitytime) {

        System.out.println(reInterviewEntitytime.getId());
        reInterviewDao.updatetonguo(reInterviewEntitytime.getId());


    }
}
