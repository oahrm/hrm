package com.hrm.oa.vo;

import com.hrm.oa.entity.Emp;
import lombok.Data;

@Data
public class PageParam {

    //页码
    private String page;
    //大小
    private String size;
    //关键词
    private Emp emp;
}
