package com.dave.common;

import com.dave.common.util.LoginClearHandler;
import com.dave.common.util.ResponseJsonUtil;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 19:10
 * @Version 1.0.0
 * @Description  用户登录处理
 **/
public class PowerInterptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String handlerStr=handler.toString();
        String packUrl=null;
        try {
            if (handlerStr.indexOf("#")>ConstantPool.NEGATIVE_ONE)
                packUrl=handlerStr.substring(0,handlerStr.indexOf("#"));
            //   静态资源权限控制
            else if (handlerStr.indexOf("ResourceHttpRequestHandler")>=ConstantPool.ZERO)
                    return true;

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            ResponseJsonUtil.fail(response,HttpServletResponse.SC_NOT_FOUND,"请求资源不存在");
            return false;
        }
        if (!LoginClearHandler.isLoginClear(handler,packUrl)){
            if (request.getSession(true).getAttribute(ConstantPool.LOGIN_ACCOUNT)==null) { //这是判断Session是否过期
                ResponseJsonUtil.fail(response,HttpServletResponse.SC_NOT_IMPLEMENTED,"您还未登录系统，请先登录或注册");
                return false;
            }else
                return true;
        }
        else
            return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}