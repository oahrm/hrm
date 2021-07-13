package com.hrm.oa.service;

import com.hrm.oa.entity.ReOfferlinEntity;
import com.hrm.oa.entity.ReResumeEntity;
import com.hrm.oa.vo.PageVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ReResumeService {

    public Map<String, Object> findAll(PageVo pageVo) ;


}
