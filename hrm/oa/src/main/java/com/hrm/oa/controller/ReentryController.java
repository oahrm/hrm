package com.hrm.oa.controller;

import com.hrm.oa.entity.ReInterviewEntitytime;
import com.hrm.oa.entity.RwruzhitonghiEntity;
import com.hrm.oa.service.ReNoticeService;
import com.hrm.oa.vo.PageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 入职通知Controller
 */
@CrossOrigin
@RestController
@RequestMapping("/reentry")
public class ReentryController {

    @Autowired
    ReNoticeService reNoticeService;

    /**
     * 初始化  获取所需数据
     *
     */
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    public Result imporrezhi(@RequestBody PageVo pageVo) throws Exception {
        if (pageVo.getPage() == null) {
            pageVo.setPage(1);
        }
        if (pageVo.getPagesize() == null) {
            pageVo.setPagesize(10);
        }
        //获取列表
        Map<String, Object> list = reNoticeService.list(pageVo);
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 添加
     */

    @RequestMapping(value = "add" ,method = RequestMethod.PUT)
    public Result addruzhi(@RequestBody RwruzhitonghiEntity reInterviewEntitytime) throws Exception {
        //获取列表
        reNoticeService.save(reInterviewEntitytime);
        return new Result(ResultCode.SUCCESS);




    }


}
