package com.hrm.oa.dao;

import com.hrm.oa.entity.ReOffer;

public interface ReOfferDao {
    int deleteByPrimaryKey(String offerId);

    int insert(ReOffer record);

    int insertSelective(ReOffer record);

    ReOffer selectByPrimaryKey(String offerId);

    int updateByPrimaryKeySelective(ReOffer record);

    int updateByPrimaryKey(ReOffer record);
}