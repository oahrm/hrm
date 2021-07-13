package com.hrm.oa.controller;

//import com.hrm.oa.entity.RePosimanEntity;
//import com.hrm.oa.service.ReJobRequirementService;
//import com.hrm.oa.service.RePosimanService;
//import com.hrm.oa.vo.PageVo;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 职位管理Controller
 */

@CrossOrigin
@RestController
@RequestMapping("/recruit")
public class RePosimanController {

//    @Autowired
//    RePosimanService rePosimanService;




    /**
     * 查询编制管理列表
     *
     */
//    @RequestMapping(value = "" ,method = RequestMethod.POST)
//    public Result importExcel(@RequestBody PageVo pageVo) throws Exception {
//        if (pageVo.getPage() == null) {
//            pageVo.setPage(1);
//        }
//        if (pageVo.getPagesize() == null) {
//            pageVo.setPagesize(10);
//        }
//        //获取列表
//        Map<String, Object> list = rePosimanService.list(pageVo);
//        return new Result(ResultCode.SUCCESS,list);
//    }
//
//    /**
//     * 查询编制管理列表
//     *
//     */
//    @RequestMapping(value = "add" ,method = RequestMethod.PUT)
//    public Result addjihua(@RequestBody RePosimanEntity rePosimanEntity) throws Exception {
//        //获取列表
//        rePosimanService.save(rePosimanEntity);
//        return new Result(ResultCode.SUCCESS);
//    }
//
//    /**
//     * 删除
//     *
//     */
//    @RequestMapping(value = "del" ,method = RequestMethod.PUT)
//    public Result deljihua(@RequestBody RePosimanEntity rePosimanEntity) throws Exception {
//        //删除
//        rePosimanService.delposi(rePosimanEntity);
//        return new Result(ResultCode.SUCCESS);
//    }


}
