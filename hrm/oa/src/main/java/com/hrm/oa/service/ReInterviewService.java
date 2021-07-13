package com.hrm.oa.service;

import com.hrm.oa.entity.ReInterviewEntitytime;
import com.hrm.oa.vo.PageVo;

import java.text.ParseException;
import java.util.Map;

public interface ReInterviewService {
    Map<String, Object> list(PageVo pageVo);

    void save(ReInterviewEntitytime reInterviewEntitytime) throws ParseException;

    void modifytonguo(ReInterviewEntitytime reInterviewEntitytime);
}
