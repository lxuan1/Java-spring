package com.dave.bean;



import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 15:33
 * @Version 1.0.0
 * @Description 账户实体
 **/

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long aID;
    private String loginName;
    private transient String  passWord;
    private String eMail;
    private String realName;
    private Integer active;
    private LocalDateTime createDateTime;
    private Long createAid;

    private String headImg;

    public Long getAID() {
        return aID;
    }

    public void setAID(Long aID) {
        this.aID = aID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getCreateAid() {
        return createAid;
    }

    public void setCreateAid(Long createAid) {
        this.createAid = createAid;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aID=" + aID +
                ", loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", eMail='" + eMail + '\'' +
                ", realName='" + realName + '\'' +
                ", active=" + active +
                ", createDateTime=" + createDateTime +
                ", createAid=" + createAid +
                '}';
    }
}
