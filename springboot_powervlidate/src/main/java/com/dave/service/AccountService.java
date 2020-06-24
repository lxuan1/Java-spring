package com.dave.service;

import com.dave.bean.Account;
import com.dave.bean.Role;
import com.dave.bean.viewbean.RoleAccountView;
import com.dave.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 16:08
 * @Version 1.0.0
 * @Description AccountService
 **/
@Service
@Qualifier(value = "accountService")
public class AccountService {
    @Autowired
    private AccountDao accountDao;


    /**
     * 根据账户id 获取账户信息
     * @param aID
     * @return Account
     */
    public Account getAccountByAID(Integer aID){
        return accountDao.getAccountByAID(aID);
    }

    /**
     *  根据用户名和密码获取账户信息
     * @param loginName 用户名
     * @param passWord 密码
     * @return  Account
     */
    public Account getAccountByLAndP(String loginName, String passWord){
        return accountDao.getAccountByLAndP(loginName,passWord);
    }


}
