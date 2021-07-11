package com.hrm.oa.service;

import com.hrm.oa.entity.RePosimanEntity;

import java.util.List;

public interface RePosimanService {

    public List<RePosimanEntity> list();

    public void save(RePosimanEntity rePosimanEntity);

}
