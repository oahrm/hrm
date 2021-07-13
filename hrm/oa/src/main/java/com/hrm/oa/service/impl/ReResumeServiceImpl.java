package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.hrm.oa.dao.ReResumeDao;
import com.hrm.oa.entity.ReResumeEntity;
import com.hrm.oa.service.ReResumeService;
import com.hrm.oa.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReResumeServiceImpl implements ReResumeService {
    @Autowired
    ReResumeDao reResumeDao;


    @Override
    public Map<String, Object> findAll(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getPagesize());
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",reResumeDao.findAll());
        map.put("tit",reResumeDao.tit());

        return map;


    }
}
