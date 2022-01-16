package com.hui.ad.advice;

import com.hui.ad.annotation.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.hui.ad.vo.CommonResponse;

/**
 * 统一响应处理
 * @RestControllerAdvice 对控制器进行增强
 * ResponseBodyAdvice接口，响应体返回之前做一些自定义的处理
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     *  判断响应是否要进行统一响应处理
     * @param methodParameter
     * @param aClass
     * @return  指定哪些方法需要进行处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        //如果类被IgnoreResponseAdvice标记，不进行统一响应处理
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        //如果方法被IgnoreResponseAdvice标记，不进行统一响应处理
        else if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    /**
     *  对响应进行统一响应处理，一般只需要关注第一个：Object
     * @param o   原始的Controller返回的内容
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response=new CommonResponse<>(0,"");
        //o就是原始的controller返回的内容
        if(o==null){
            return  response;
        }if(o instanceof CommonResponse){
            response=(CommonResponse<Object>) o;
        }else{
            response.setData(o);
        }
        return response;
    }
}
