package com.hui.ad.advice;

import com.hui.ad.exception.AdException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hui.ad.vo.CommonResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * ExceptionHandler(value = AdException.class)
     * ExceptionHandler对指定spring的进行异常处理
     * value = AdException.class 对AdException异常进行统一处理
     * 优化：定义多种类异常，并实现对应的异常处理
     * Binlog解析异常：抛出BinlogException
     */
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerException(HttpServletRequest request, AdException ex){
        /**
         * 统一异常接口的响应
         * 优化：定义不同类型的异常枚举（异常码和异常信息）
         */
        CommonResponse<String> response=new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());
        return response;
    }
}
