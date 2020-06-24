package com.dave.bean;

import java.time.LocalDateTime;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 16:03
 * @Version 1.0.0
 * @Description 角色表
 **/
public class Role {
    private Integer rID;
    private String roleName;
    private Integer active;
    private String roleDesc;
    private LocalDateTime createDateTime;

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
