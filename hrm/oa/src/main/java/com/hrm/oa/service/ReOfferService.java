package com.hrm.oa.service;

import com.hrm.oa.entity.ReOffer;

import java.util.List;

public interface ReOfferService {

    //查询出offer状态为以同意数据到劳务合同签署界面
    List<ReOffer> selectOffer_Hucontracto();
}
