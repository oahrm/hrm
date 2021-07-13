package com.hrm.oa.service.impl;

import com.hrm.oa.entity.HuPosttransfer;
import com.hrm.oa.dao.HuPosttransferDao;
import com.hrm.oa.service.HuPosttransferService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工调岗记录表(HuPosttransfer)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 20:11:14
 */
@Service("huPosttransferService")
public class HuPosttransferServiceImpl implements HuPosttransferService {
    @Resource
    private HuPosttransferDao huPosttransferDao;

    /**
     * 查询员工的调岗数据
     *
     */
    @Override
    public List<HuPosttransfer> queryByEmpId(String transferName) {
        return this.huPosttransferDao.queryByEmpId(transferName);
    }

    /**
     * 新增数据
     * @param huPosttransfer 实例对象
     * @return 实例对象
     */
    @Override
    public HuPosttransfer insert(HuPosttransfer huPosttransfer) {
        this.huPosttransferDao.insert(huPosttransfer);
        return huPosttransfer;
    }
}
