package com.hrm.oa.dao;

import com.hrm.oa.entity.ReOfferlinEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReOfferlinDao {
    int deleteByPrimaryKey(String offerId);

    int insert(ReOfferlinEntity record);

    int insertSelective(ReOfferlinEntity record);

    ReOfferlinEntity selectByPrimaryKey(String offerId);

    int updateByPrimaryKeySelective(ReOfferlinEntity record);

    int updateByPrimaryKey(ReOfferlinEntity record);
    List<ReOfferlinEntity> findlist();
}