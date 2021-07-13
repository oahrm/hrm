package com.hrm.oa.service;

import com.hrm.oa.entity.HuPosttransfer;

import java.util.List;

/**
 * 员工调岗记录表(HuPosttransfer)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 20:11:14
 */
public interface HuPosttransferService {

    /**
     * 查询员工的调岗数据
     * @return 实例对象
     */
    List<HuPosttransfer> queryByEmpId(String transferName);

    /**
     * 新增数据
     *
     * @param huPosttransfer 实例对象
     * @return 实例对象
     */
    HuPosttransfer insert(HuPosttransfer huPosttransfer);



}
