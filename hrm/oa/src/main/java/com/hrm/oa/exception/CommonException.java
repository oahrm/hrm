package com.hrm.oa.exception;


import com.hrm.oa.vo.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception{

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
}
