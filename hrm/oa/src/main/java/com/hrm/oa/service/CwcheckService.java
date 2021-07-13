package com.hrm.oa.service;

import com.hrm.oa.entity.CwCheck;

import java.util.List;

public interface CwcheckService {
    List<CwCheck> selectBycheck();
    int insertcheck(CwCheck cwCheck);
}
