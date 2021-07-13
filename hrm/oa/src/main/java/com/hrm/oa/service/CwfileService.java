package com.hrm.oa.service;

import com.hrm.oa.entity.CwFieldPersonnel;

import java.util.List;

public interface CwfileService {

    int insertfile(CwFieldPersonnel cwFieldPersonnel);

    List<CwFieldPersonnel> selectByfile();

    List<CwFieldPersonnel> selectBydept(String value);
}
