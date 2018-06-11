package com.ghds.alumni.domain.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.RoleprivilegeEntity;

import java.util.List;

public class Roleprivilege extends RoleprivilegeEntity {

    /**
     * 菜单权限的type
     */
    public final static Integer TYPE_MENU = 3;
    /**
     * 功能权限的type
     */
    public final static Integer TYPE_FUNC = 4;
    /**
     * 系统权限的type
     */
    public final static Integer TYPE_SUBSYSTEM = 1;
    /**
     * 提交的菜单id
     */
    private List<String> menuIds;
    /**
     * 提交的权限id
     */
    private List<String> funcIds;


    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }

    public List<String> getFuncIds() {
        return funcIds;
    }

    public void setFuncIds(List<String> funcIds) {
        this.funcIds = funcIds;
    }
}
