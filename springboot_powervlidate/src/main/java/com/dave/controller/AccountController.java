package com.dave.controller;

import com.dave.bean.Account;
import com.dave.bean.Role;
import com.dave.bean.viewbean.RoleAccountView;
import com.dave.common.ConstantPool;
import com.dave.common.customannotation.LoginClear;
import com.dave.common.util.ResponseJsonUtil;
import com.dave.dao.MenuDao;
import com.dave.service.AccountService;
import com.dave.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 18:00
 * @Version 1.0.0
 * @Description
 **/
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private MenuService menuService;


    /**
     * 用户登录
     * @return
     */
    @LoginClear
    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }
    /**
     * 用户登录验证
     * @param loginName 用户名
     * @param passWord 密码
     * @return json
     */
    @LoginClear
    @ResponseBody
    @PostMapping("/validateAccount")
    @CrossOrigin
    public Map<String,Object> validateLAndP(@RequestParam("loginName") String loginName, @RequestParam("passWord") String passWord,HttpServletRequest request){
        //HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        loginName=StringUtils.trimAllWhitespace(loginName);
        passWord=StringUtils.trimAllWhitespace(passWord);
        if ("".equals(loginName)||loginName==null)
            return ResponseJsonUtil.fail(300,"用户名不能为空");
        else if ("".equals(passWord)||passWord==null)
            return ResponseJsonUtil.fail(300,"密码不能为空");
        else{
            Account account=accountService.getAccountByLAndP(loginName,passWord);
            if (account==null)
                return ResponseJsonUtil.fail(404,"用户名或密码错误！");
            else{
                request.getSession(true).setAttribute(ConstantPool.LOGIN_ACCOUNT,account);
                return ResponseJsonUtil.ok("登录成功！");
                //return this.getMenu(account,request);
            }
        }
    }

    @RequestMapping("/getAccount")
    public String getAccount(){
        Account account = accountService.getAccountByAID(1);
        System.out.println(account.toString());
        return "getAccount";
    }

    @RequestMapping("/list1")
    public String list1(){
        return "list1";
    }

    @RequestMapping("/addAccount1")
    public Map addAccount(){
        Map<String,Object> map=new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        return map;
    }
    @RequestMapping("/deleteAccount")
    public Boolean deleteAccount(){
        return true;
    }

    @RequestMapping("/updateAccount")
    public Integer updateAccount(){
        return 1;
    }

    /**
     * 用户登陆后设置 资源定位符列表和菜单权限
     * @param account
     * @param request
     * @return
     */
    private Map<String, Object> getMenu(Account account,HttpServletRequest request)
    {
        synchronized (account){
            request.getSession(true).setAttribute(ConstantPool.ROLE_LIST,menuService.listRoleAccountView(account.getAID()));
            List<RoleAccountView> roleAccountViews=menuService.listMenu(account.getAID(),null,ConstantPool.ZERO);
            return ResponseJsonUtil.ok("登录成功",roleAccountViews);
        }
    }
}
