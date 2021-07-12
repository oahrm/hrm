package com.hrm.oa.controller;

import com.hrm.oa.entity.PeIndexList;
import com.hrm.oa.service.PeIndexListService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 指标列表(PeIndexList)表控制层
 *
 * @author makejava
 * @since 2021-07-12 16:26:26
 */
@RestController
@RequestMapping("/peIndexList")
public class PeIndexListController {
    /**
     * 服务对象
     */
    @Resource
    private PeIndexListService peIndexListService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public PeIndexList selectOne(String indexId) {
        return this.peIndexListService.queryById(indexId);
    }

    @PostMapping("/findAll")
    public Result findAllIndexList(@RequestBody PeIndexList peIndexList){
        System.out.println("查询考核指标项");
        System.out.println(peIndexList.getEmpId());
        List<PeIndexList> lists = peIndexListService.queryAllIndexList(peIndexList);
        return new Result(ResultCode.SUCCESS,lists);
    }



}
