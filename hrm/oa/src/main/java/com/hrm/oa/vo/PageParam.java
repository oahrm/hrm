package com.hrm.oa.vo;

import lombok.Data;

@Data
public class PageParam {

    //页码
    private int page;
    //大小
    private int size;
    //关键词
    private String keywords;
}
