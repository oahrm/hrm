package com.hrm.oa.service;

import com.hrm.oa.entity.ReEntryApplica;
import com.hrm.oa.entity.ReOffer;

import java.util.List;

public interface ReOfferService {

    //查询出offer状态为以同意数据到劳务合同签署界面
    List<ReOffer> selectOffer_Hucontracto();

    //将签署状态更改为1
    int updateOffer_Hucontracto(Integer id);

    //查询出签署状态为以1的数据到员工入职页面
    List<ReOffer> selectOffer_HuPersonnelbecome();

    //将入职状态更改为1
    int updateOffer_HuPersonnelbecome(Integer id);
}
