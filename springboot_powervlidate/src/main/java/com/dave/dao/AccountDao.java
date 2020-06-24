package com.dave.dao;

import com.dave.bean.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 15:59
 * @Version 1.0.0
 * @Description
 **/
@Repository
public interface AccountDao {
    /**
     * 根据账户id 获取账户信息
     * @param aID
     * @return Account
     */
    Account getAccountByAID(Integer aID);

    /**
     *  根据用户名和密码获取账户信息
     * @param loginName 用户名
     * @param passWord 密码
     * @return  Account
     */
    Account getAccountByLAndP(@Param("loginName") String loginName, @Param("passWord") String passWord);




}

