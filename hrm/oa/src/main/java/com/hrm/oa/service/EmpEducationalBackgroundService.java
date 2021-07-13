package com.hrm.oa.service;

import com.hrm.oa.entity.EmpEducationalBackground;

import java.util.List;

/**
 * 学历背景表(EmpEducationalBackground)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 14:14:02
 */
public interface EmpEducationalBackgroundService {

    /**
     * 查询某个人的教育背景
     */
    List<EmpEducationalBackground> queryByEduEmpId(String empId);

}
