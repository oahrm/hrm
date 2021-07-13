package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.hrm.oa.dao.ReJobRequirementsDao;
import com.hrm.oa.entity.ReJobRequirementsEntity;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.service.ReJobRequirementService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReJobRequirementServiceImpl implements ReJobRequirementService {
    @Autowired
    ReJobRequirementsDao reJobRequirementsDao;

    @Autowired
    protected IdWorker idWorker;
    @Override
    public Map<String, Object> list(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getPagesize());
        List<ReJobRequirementsEntity> list = reJobRequirementsDao.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",list);
        //岗位数
        map.put("sumdemand",reJobRequirementsDao.sumdemand());
        //岗位需求人数
        map.put("demandNumsum",reJobRequirementsDao.demandNumsum());
        //岗位数
        map.put("tit",reJobRequirementsDao.sumdemand());
        return map;

    }

    @Override
    public int save(ReJobRequirementsEntity reJobRequirementsEntity) {

            reJobRequirementsEntity.setJobId(idWorker.nextId() + "");
            reJobRequirementsEntity.setApplicationTime(new Date());
            reJobRequirementsEntity.setStats(0);
            return reJobRequirementsDao.insert(reJobRequirementsEntity);

    }

    @Override
    public int delposi(ReJobRequirementsEntity reJobRequirementsEntity) {
        return reJobRequirementsDao.deleteByPrimaryKey(reJobRequirementsEntity.getJobId());
    }

    /**
     * 修改
     * @param reJobRequirementsEntity
     */
    @Override
    public int modifyjob(ReJobRequirementsEntity reJobRequirementsEntity) {
        if(reJobRequirementsEntity.getStats()==0) {
            reJobRequirementsEntity.setStats(1);
        }else{
            reJobRequirementsEntity.setStats(0);
        }
        return reJobRequirementsDao.updateByPrimaryKeySelective(reJobRequirementsEntity);

    }

}
