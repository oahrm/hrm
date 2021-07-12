package com.hrm.oa.dao;

import com.hrm.oa.entity.ReOffer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReOfferDao {
    int deleteByPrimaryKey(String offerId);

    int insert(ReOffer record);

    int insertSelective(ReOffer record);

    //查询出offer状态为以同意数据到劳务合同签署界面
    List<ReOffer> selectOffer_Hucontracto();

    ReOffer selectByPrimaryKey(String offerId);

    int updateByPrimaryKeySelective(ReOffer record);

    int updateByPrimaryKey(ReOffer record);
}