package com.hrm.oa.controller;

import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.ReOfferService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ReOfferController {
    @Autowired
    private ReOfferService reOfferService;

    //查询出offer状态为以同意数据到劳务合同签署界面
    @GetMapping("/selectAllOffer_Hu")
    public Result selectAllOffer_Hu(){
        log.debug("Controller查询出offer状态为以同意数据到劳务合同签署界面");

        List<ReOffer> offer_hucontracto=reOfferService.selectOffer_Hucontracto();
        return new Result(ResultCode.SUCCESS,offer_hucontracto);
    }
}
