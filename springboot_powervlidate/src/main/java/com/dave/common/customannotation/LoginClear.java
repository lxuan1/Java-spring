package com.dave.common.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/8 18:50
 * @Version 1.0.0
 * @Description  清除登录限制
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface LoginClear {
    String value() default "";
}
