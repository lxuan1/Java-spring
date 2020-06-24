package com.dave.dao;

import com.dave.bean.Role;
import com.dave.bean.viewbean.RoleAccountView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/22 16:33
 * @Version 1.0.0
 * @Description
 **/
@Repository

public interface MenuDao  {
    /**
     * 根据用户名和密码获取账户的角色和权限等信息
     * @param aID 用户ID
     */
    List<RoleAccountView> listRoleAccountView(@Param("aID") Long aID);

    /**
     * 获取menu菜单
     * @param aID 账户ID
     * @param pID 路由ID
     * @param level 级别
     * @return listMenu
     */
    List<RoleAccountView> listMenu(@Param("aID") Long aID,@Param("pID") Integer pID,@Param("level") Integer level);

}
