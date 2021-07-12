package com.hrm.oa.service.impl;

import com.hrm.oa.entity.PrDetailproject;
import com.hrm.oa.service.PrDetailprojectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Bkiller
 * @Date: 2021/07/12/19:31
 * @Description:
 */
@Service("prDetailprojectService")
public class PrDetailprojectServiceImpl implements PrDetailprojectService {
    @Override
    public PrDetailproject queryById(String dId) {
        return null;
    }

    @Override
    public List<PrDetailproject> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public PrDetailproject insert(PrDetailproject prDetailproject) {
        return null;
    }

    @Override
    public PrDetailproject update(PrDetailproject prDetailproject) {
        return null;
    }

    @Override
    public boolean deleteById(String dId) {
        return false;
    }
}
