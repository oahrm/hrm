package com.hrm.oa.controller;

import com.hrm.oa.entity.EmpMessageRecord;
import com.hrm.oa.service.EmpMessageRecordService;
import com.hrm.oa.vo.Result;
import com.hrm.oa.vo.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (EmpMessageRecord)表控制层
 *
 * @author makejava
 * @since 2021-07-12 15:20:13
 */
@RestController
@RequestMapping("message")
public class EmpMessageRecordController {
    /**
     * 服务对象
     */
    @Resource
    private EmpMessageRecordService empMessageRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EmpMessageRecord selectOne(String id) {
        return this.empMessageRecordService.queryById(id);
    }

    /**
     * 添加一条消息录
     * @param empMessageRecord
     * @return
     */
    @PostMapping("/addMessage")
    public Result addMessage(@RequestBody EmpMessageRecord empMessageRecord){
        empMessageRecordService.insert(empMessageRecord);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 添加多条消息录
     * @return
     */
    @PostMapping("/addAllMessage")
    public Result addAllMessage(@RequestBody Map map){
        empMessageRecordService.addAllMessage((List<EmpMessageRecord>) map.get("messageList"));
        return new Result(ResultCode.SUCCESS);
    }

}
