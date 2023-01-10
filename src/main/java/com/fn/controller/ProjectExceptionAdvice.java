package com.fn.controller;

import com.fn.exception.BusinessException;
import com.fn.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 定义异常处理器，这里来处理所有的异常（分为业务异常、系统异常、其他异常）
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException be) {
        return new Result(be.getCode(), null, be.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException se) {
        //记录日志（错误堆栈）
        //发送邮件给开发人员，ex对象发送给开发人员
        //发送短信给运维人员
        return new Result(se.getCode(), null, se.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        //记录日志（错误堆栈）
        //发送邮件给开发人员，exception对象发送给开发人员
        //发送短信给运维人员
        exception.printStackTrace();
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "系统繁忙，请稍后再试");
    }
}
