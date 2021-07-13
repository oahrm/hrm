package com.hrm.oa.controller;

import com.hrm.oa.entity.ReInterviewEntitytime;
import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.service.ReInterviewService;
import com.hrm.oa.vo.PageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 面试管理
 */
@CrossOrigin
@RestController
@RequestMapping("/inter")
public class ReInterviewController {

    @Autowired
    ReInterviewService reInterviewService;

    /**
     * 查询所有
     *
     */
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    public Result imporjobrequ(@RequestBody PageVo pageVo) throws Exception {
        if (pageVo.getPage() == null) {
            pageVo.setPage(1);
        }
        if (pageVo.getPagesize() == null) {
            pageVo.setPagesize(10);
        }
        //获取列表
        Map<String, Object> list = reInterviewService.list(pageVo);
        return new Result(ResultCode.SUCCESS,list);
        }

    /**
     * 添加
     */
    /* *
     * 添加岗位需求*/

    @RequestMapping(value = "addjob" ,method = RequestMethod.PUT)
    public Result addjobrequ(@RequestBody ReInterviewEntitytime reInterviewEntitytime) throws Exception {
        //获取列表
        reInterviewService.save(reInterviewEntitytime);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "modifytonguo" ,method = RequestMethod.PUT)
    public Result modify(@RequestBody ReInterviewEntitytime reInterviewEntitytime) throws Exception {
        reInterviewService.modifytonguo(reInterviewEntitytime);
        return new Result(ResultCode.SUCCESS);
    }
}
