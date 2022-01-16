package com.hui.ad.annotation;

import java.lang.annotation.*;

/**
 * 定义一个注解IgnoreResponseAdvice
 * @Target({ElementType.TYPE,ElementType.METHOD})  可以注解在类或者方法上
 * @Retention(RetentionPolicy.RUNTIME)  在运行时有效
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
