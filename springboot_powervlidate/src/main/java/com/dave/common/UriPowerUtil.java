package com.dave.common;

import com.dave.bean.viewbean.RoleAccountView;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/9 11:11
 * @Version 1.0.0
 * @Description
 **/
@Component
public class UriPowerUtil {

    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    /**
     * 验证是否有权限
     * @param joinPoint 切入点方法信息
     * @param roleAccountViews   权限集合
     * @param CRUD 标识符
     * @return  返回值说明：
     *            -1  截取出错
     *             3 ：该请求不是有效的action
     *             2： 表示用户登录已过期
     *             1： 用户有该权限
     *             0：用户无该权限
     */
    public synchronized int powerValidate(JoinPoint joinPoint, List<RoleAccountView> roleAccountViews, char CRUD){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        String packAgeAndMethodName=getActionUrl(joinPoint);
        // 截取出错 -1
        if (packAgeAndMethodName==null)
            return ConstantPool.NEGATIVE_ONE;
        else {
            //.findFirst().get().toString();
            Optional<HandlerMethod> handlerMethodStream = handlerMethods.values().stream().filter(x -> x.toString().startsWith(packAgeAndMethodName)).findFirst();
            // 通过链接查找 spring mvc RequestMappingInfo 集合， 如果没有找到 则该请求不是有效的action  0
            if (handlerMethodStream.get()!=null){
                // 取出第一值 handlerMethods的value值
                String actionMethod = handlerMethodStream.get().toString();
                //通过 actionMethod值取出他的key值
                String actionUrl=handlerMethods.keySet().stream().filter(x-> handlerMethods.get(x).toString().equals(actionMethod))
                        .findFirst().get().toString().replace("{","").replace("}","").trim();
                return this.urlListValidate(roleAccountViews,actionUrl,CRUD);
            }
            return 3;
        }
    }

    protected  String getActionUrl(JoinPoint  joinPoint){
        try {
            String joinPointStr=joinPoint.toString();
            return joinPointStr.substring(joinPointStr.indexOf("com"),joinPointStr.lastIndexOf("(")).replaceAll("(\\.)(?!.*\\1)","#");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 验证 该用户是否连接操作 CRUD 权限
     * @param rolePowerList 角色权限Session
     * @param url  当前连接
     * @param CRUD  操作类型 C-新增  R-读取  U-修改 D-删除
     * @return 返回为
     *          2： 表示用户登录已过期
     *          1： 用户有该权限
     *          0：用户无该权限
     *
     */
    public  int urlListValidate(List<RoleAccountView> rolePowerList,String url,char CRUD){
        //没有获取到用户session信息
        if (rolePowerList==null)
            return 2;
        else{
            List<RoleAccountView> uris= rolePowerList.stream().filter(x -> url.startsWith(x.getPermission().getUri())).collect(Collectors.toList());
            boolean flag=false;
            for (RoleAccountView temp: uris)
            {
                if (!flag){
                    switch (CRUD){
                        case 'C':
                            flag=temp.getActionC()==ConstantPool.ONE;
                            break;
                        case 'R':
                            flag=temp.getActionR()==ConstantPool.ONE;
                            break;
                        case 'U':
                            flag=temp.getActionU()==ConstantPool.ONE;
                            break;
                        case 'D':
                            flag=temp.getActionD()==ConstantPool.ONE;
                            break;
                            default:
                                break;
                    }
                }
                else
                   break;
            }
            return flag?ConstantPool.ONE:ConstantPool.ZERO;
        }
    }
}
