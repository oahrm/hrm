package com.hrm.oa.dao;

import com.hrm.oa.entity.HuPersonnelentry;

public interface HuPersonnelentryDao {
    int deleteByPrimaryKey(String personnelentryId);

    int insert(HuPersonnelentry record);

    int insertSelective(HuPersonnelentry record);

    HuPersonnelentry selectByPrimaryKey(String personnelentryId);

    int updateByPrimaryKeySelective(HuPersonnelentry record);

    int updateByPrimaryKey(HuPersonnelentry record);
}