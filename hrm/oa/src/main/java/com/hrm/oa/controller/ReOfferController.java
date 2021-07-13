package com.hrm.oa.controller;

import com.hrm.oa.entity.ReEntryApplica;
import com.hrm.oa.entity.ReOffer;
import com.hrm.oa.service.ReOfferService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //将签署状态更改为1
    @PutMapping("/updateOffer_Hu/{id}")
    public int updateOffer_Hucontracto(@PathVariable("id") Integer id){
        return  reOfferService.updateOffer_Hucontracto(id);
    }

    //查询出签署状态为以1的数据到员工入职页面
    @GetMapping("/selectAllOffer_HuP")
    public Result selectOffer_HuPersonnelbecome(){
        log.debug("Controller查询出offer状态为以同意数据到劳务合同签署界面");
        List<ReOffer> offer_hucontracto=reOfferService.selectOffer_HuPersonnelbecome();
        return new Result(ResultCode.SUCCESS,offer_hucontracto);
    }

    //将入职状态改为1
    @PutMapping("/updateOffer_HuP/{id}")
    public int updateOffer_HuPersonnelbecome(@PathVariable("id") Integer id){
        System.out.println("==----------------------------------------"+id);
        return  reOfferService.updateOffer_HuPersonnelbecome(id);
    }


}
