package com.hrm.oa.controller;

import com.hrm.oa.dao.ReJobRequirementsDao;
import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.service.ReJobRequirementService;
import com.hrm.oa.vo.PageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 岗位需求Controller
 */
@CrossOrigin
@RestController
@RequestMapping("/job")
public class ReJobRequeirController {
    /**
     * re_job_requirements表
     */
    @Autowired
    ReJobRequirementService reJobRequirementService;


    /**
     * 查询岗位需求
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
        Map<String, Object> list = reJobRequirementService.list(pageVo);
        return new Result(ResultCode.SUCCESS,list);
    }

   /* *
     * 添加岗位需求*/
    @RequestMapping(value = "addjob" ,method = RequestMethod.PUT)
    public Result addjobrequ(@RequestBody ReJobRequirementsEntity reJobRequirementsEntity) throws Exception {
        //获取列表
        reJobRequirementService.save(reJobRequirementsEntity);
        return new Result(ResultCode.SUCCESS);
    }

   /* *
     * 查询编制管理列表
     *
    */
    @RequestMapping(value = "deljob" ,method = RequestMethod.DELETE)
    public Result deljobrequ(@RequestBody ReJobRequirementsEntity reJobRequirementsEntity) throws Exception {
        //删除
        reJobRequirementService.delposi(reJobRequirementsEntity);
        return new Result(ResultCode.SUCCESS);
    }

    /* *
     * 修改状态
     *
     */
    @RequestMapping(value = "modifyjob" ,method = RequestMethod.PUT)
    public Result modify(@RequestBody ReJobRequirementsEntity reJobRequirementsEntity) throws Exception {
        reJobRequirementService.modifyjob(reJobRequirementsEntity);
        return new Result(ResultCode.SUCCESS);
    }
}
