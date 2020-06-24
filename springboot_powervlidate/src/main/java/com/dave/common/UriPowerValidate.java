package com.dave.common;

import com.dave.bean.viewbean.RoleAccountView;
import com.dave.common.util.ResponseJsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/9 9:29
 * @Version 1.0.0
 * @Description CRUD 权限验证
 **/
@Component
@Aspect
public class UriPowerValidate {

    @Autowired
    private  UriPowerUtil uriPowerUtil;
    @Around("listPointCut()")
    public Object listValidate(ProceedingJoinPoint joinPoint){
        return this.validate(joinPoint,'R');
    }

    @Around("addPointCut()")
    public Object addValidate(ProceedingJoinPoint joinPoint){
        return this.validate(joinPoint,'C');
    }

    @Around("updatePointCut()PointCut()")
    public Object updateValidate(ProceedingJoinPoint joinPoint){
        return this.validate(joinPoint,'U');
    }

    @Around("deletePointCut()")
    public Object deleteValidate(ProceedingJoinPoint joinPoint){
        return this.validate(joinPoint,'D');
    }

    /**
     * 切入点逻辑验证
     * @param joinPoint  切入方法信息
     * @param CRUD  增删改查标识
     */
    private Object validate(ProceedingJoinPoint joinPoint,char CRUD) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //Signature signature = joinPoint.getSignature();
        List<RoleAccountView> roleAccountViews=getUserInfoSession(request);
        if (roleAccountViews==null)
           return ResponseJsonUtil.fail(HttpServletResponse.SC_NOT_IMPLEMENTED,"您还未登录系统，请先登录或注册");
        else{
            try {
                int flag=uriPowerUtil.powerValidate(joinPoint,roleAccountViews,CRUD);
                if (flag==ConstantPool.ONE)
                    return joinPoint.proceed(joinPoint.getArgs());
                else if (flag==ConstantPool.ZERO)
                    ResponseJsonUtil.fail(response,HttpServletResponse.SC_UNAUTHORIZED,"该请求您暂无权限！");
                else if (flag==ConstantPool.NEGATIVE_ONE)
                    ResponseJsonUtil.fail(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "出错啦，请联系管理员！");
                else if (flag==2)
                    ResponseJsonUtil.fail(response, HttpServletResponse.SC_NOT_IMPLEMENTED, "该会话已过期，请重新登录！");
                else
                     ResponseJsonUtil.fail(response,HttpServletResponse.SC_NOT_FOUND,"该请求不是有效链接，请修改后重试！");
                return null;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return ResponseJsonUtil.fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"出错啦，请联系管理员！");
            }
        }
    }

    @Before("other()")
    public void   otherValidate(JoinPoint joinPoint){

    }


    /**
     * 获取session值，
     * @return List
     */
    public List<RoleAccountView> getUserInfoSession(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        List<RoleAccountView> lists = (List)session.getAttribute(ConstantPool.ROLE_LIST);
        return lists;
    }

    /**
     * 查询切入点
     */
    @Pointcut(value = "execution(public * com.dave.controller..*Controller.list*(..))")
    public void listPointCut(){

    }

    /**
     * 新增切入点
     */
    @Pointcut(value = "execution(public * com.dave.controller..*Controller.add*(..))")
    public void addPointCut(){

    }

    /**
     * 删除切入点
     */
    @Pointcut(value = "execution(public * com.dave.controller..*Controller.delete*(..))")
    public void deletePointCut(){

    }

    /**
     *  修改切入点
     */
    @Pointcut(value = "execution(public * com.dave.controller..*Controller.update*(..))")
    public void updatePointCut(){

    }

    /**
     * 测试切入点
     */
    @Pointcut(value = "execution(public * com.dave.controller..Controller.test(..))")
    public void other(){

    }
}
