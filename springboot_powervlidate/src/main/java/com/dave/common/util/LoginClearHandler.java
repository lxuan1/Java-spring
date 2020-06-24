package com.dave.common.util;

import com.dave.common.customannotation.LoginClear;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/8 18:53
 * @Version 1.0.0
 * @Description
 **/
public class LoginClearHandler {

    private LoginClearHandler(){

    }

    /***
     * 获取类的实例
     * @param classPath class路径
     * @return Class
     */
    public static Class<?> getClazz(String classPath)
    {
        if ("".equals(classPath)||classPath==null)
            return null;
        else {
            try {
                return Class.forName(classPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * 判断是否有LoginClear 注解，才能判断是否需要登录验证
     * @param handler 类
     * @return boolean 有注解 true  无注解  false
     */
    public static boolean isLoginClear(Object handler,String packUrl){
        if (handler instanceof HandlerMethod){
            Class<?> clazz=getClazz(packUrl);
//            System.out.println(clazz.isAnnotationPresent(LoginClear.class));
//            System.out.println(((HandlerMethod)handler).getMethod().isAnnotationPresent(LoginClear.class));
            if (clazz==null)
                return false;
            else if (clazz.isAnnotationPresent(LoginClear.class))
                return true;
            else
                return ((HandlerMethod)handler).getMethod().isAnnotationPresent(LoginClear.class);
        }
        return false;
    }
}
