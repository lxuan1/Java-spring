package com.dave.bean;

import java.time.LocalDateTime;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/6 16:00
 * @Version 1.0.0
 * @Description  权限表
 **/
public class Permission {
    private Integer pID;
    private String uri;
    private String permissionName;
    private Integer active;
    private LocalDateTime createDateTime;
    private Long createAid;
    private Character isMenu;
    private Integer menuParent;
    private Integer  level;

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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

    public Character getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Character isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(Integer menuParent) {
        this.menuParent = menuParent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Permission(String uri, String permissionName, Long actionC, Integer actionR, Integer actionU, Integer actionD, Integer active, LocalDateTime createDateTime, Long createAid, Character isMenu, Integer menuParent, Integer level) {
        this.uri = uri;
        this.permissionName = permissionName;
        this.active = active;
        this.createDateTime = createDateTime;
        this.createAid = createAid;
        this.isMenu = isMenu;
        this.menuParent = menuParent;
        this.level = level;
    }

    public Permission() {

    }
}
