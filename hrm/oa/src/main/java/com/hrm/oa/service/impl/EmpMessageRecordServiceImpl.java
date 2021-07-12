package com.hrm.oa.service.impl;

import com.hrm.oa.entity.EmpMessageRecord;
import com.hrm.oa.dao.EmpMessageRecordDao;
import com.hrm.oa.service.EmpMessageRecordService;
import com.hrm.oa.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (EmpMessageRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 15:20:13
 */
@Service("empMessageRecordService")
public class EmpMessageRecordServiceImpl implements EmpMessageRecordService {
    @Resource
    private EmpMessageRecordDao empMessageRecordDao;
    @Autowired
    private IdWorker idWorker;
    /**
     * 新增数据
     *
     * @param empMessageRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmpMessageRecord insert(EmpMessageRecord empMessageRecord) {
        empMessageRecord.setId(idWorker.nextId()+"");
        empMessageRecord.setSendTime(new Date());
        empMessageRecord.setStatus(0);
        this.empMessageRecordDao.insert(empMessageRecord);
        return empMessageRecord;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmpMessageRecord queryById(String id) {
        return this.empMessageRecordDao.queryById(id);
    }


    /**
     * 添加多条消息记录
     */
    @Override
    public int addAllMessage(List<EmpMessageRecord> list) {
        for (EmpMessageRecord empMessageRecord:list){
            empMessageRecord.setId(idWorker.nextId()+"");
            empMessageRecord.setSendTime(new Date());
            empMessageRecord.setStatus(0);
        }
        return empMessageRecordDao.insertBatch(list);
    }

    /**
     * 修改数据
     *
     * @param empMessageRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmpMessageRecord update(EmpMessageRecord empMessageRecord) {
        this.empMessageRecordDao.update(empMessageRecord);
        return this.queryById(empMessageRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.empMessageRecordDao.deleteById(id) > 0;
    }
}
