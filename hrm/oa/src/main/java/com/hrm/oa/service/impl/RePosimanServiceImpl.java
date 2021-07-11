package com.hrm.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.hrm.oa.dao.RePosimanDao;
import com.hrm.oa.entity.RePosimanEntity;
import com.hrm.oa.service.RePosimanService;
import com.hrm.oa.util.IdWorker;
import com.hrm.oa.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RePosimanServiceImpl implements RePosimanService {
    @Autowired
    protected RePosimanDao reposimanDao;

    @Autowired
    protected IdWorker idWorker;

    @Override
    public Map<String, Object> list(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getPagesize());
        List<RePosimanEntity> list = reposimanDao.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("posinmenlist",list);
        int staffnum=reposimanDao.staffnum();
        int actualnum=reposimanDao.actualnum();
        map.put("staffnum",staffnum);
        map.put("actualnum",actualnum);
        
        return map;
    }

    /**
     * 添加
     * @param rePosimanEntity
     * @return
     */
    @Override
    public int save(RePosimanEntity rePosimanEntity) {
        rePosimanEntity.setPmId(idWorker.nextId()+"");
        rePosimanEntity.setTime(new Date());
        return reposimanDao.insert(rePosimanEntity);

    }

    /**
     * 删除
     * @param rePosimanEntity
     * @return
     */
    @Override
    public int delposi(RePosimanEntity rePosimanEntity) {
        return reposimanDao.deleteByPrimaryKey(rePosimanEntity.getPmId());
    }
}
