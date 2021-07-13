package com.hrm.oa.service;

import com.hrm.oa.entity.RwruzhitonghiEntity;
import com.hrm.oa.vo.PageVo;

import java.util.Map;

public interface ReNoticeService {

    Map<String, Object> list(PageVo pageVo);

    void save(RwruzhitonghiEntity reInterviewEntitytime);
}
