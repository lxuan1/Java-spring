package com.dave.service;

import com.dave.bean.viewbean.RoleAccountView;
import com.dave.dao.MenuDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/22 16:38
 * @Version 1.0.0
 * @Description 菜单处理Service
 **/
@Service
public class MenuService {
    @Autowired
    private MenuDao dao;

    /**
     * 根据用户名和密码获取账户的角色和权限等信息
     * @param aID 用户ID
     */
    public List<RoleAccountView> listRoleAccountView(Long aID){
        return dao.listRoleAccountView(aID);
    }

    /**
     * 获取menu菜单
     * @param aID 账户ID
     * @param pID 路由ID
     * @param level 级别
     * @return listMenu
     */
    public List<RoleAccountView> listMenu( Long aID,Integer pID, Integer level){
       return dao.listMenu(aID,pID,level);
    }

}
