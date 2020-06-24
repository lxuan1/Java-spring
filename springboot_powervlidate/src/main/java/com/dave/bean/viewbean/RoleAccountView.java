package com.dave.bean.viewbean;

import com.dave.bean.Account;
import com.dave.bean.Permission;
import com.dave.bean.Role;
import org.springframework.web.util.pattern.PathPattern;

import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 16:06
 * @Version 1.0.0
 * @Description 用户角色实体
 **/
public class RoleAccountView {
    private Long aID;
    private Integer rID;
    private Integer rActive;
    private Permission permission;
    private Integer actionC;
    private Integer actionR;
    private Integer actionU;
    private Integer actionD;

    public Long getaID() {
        return aID;
    }

    public void setaID(Long aID) {
        this.aID = aID;
    }

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public Integer getrActive() {
        return rActive;
    }

    public void setrActive(Integer rActive) {
        this.rActive = rActive;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Integer getActionC() {
        return actionC;
    }

    public void setActionC(Integer actionC) {
        this.actionC = actionC;
    }

    public Integer getActionR() {
        return actionR;
    }

    public void setActionR(Integer actionR) {
        this.actionR = actionR;
    }

    public Integer getActionU() {
        return actionU;
    }

    public void setActionU(Integer actionU) {
        this.actionU = actionU;
    }

    public Integer getActionD() {
        return actionD;
    }

    public void setActionD(Integer actionD) {
        this.actionD = actionD;
    }

    @Override
    public String toString() {
        return "RoleAccountView{" +
                "aID=" + aID +
                ", rID=" + rID +
                ", rActive=" + rActive +
                ", permission=" + permission +
                ", actionC=" + actionC +
                ", actionR=" + actionR +
                ", actionU=" + actionU +
                ", actionD=" + actionD +
                '}';
    }
}
