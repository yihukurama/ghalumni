package com.ghds.alumni.domain.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.*;

import java.util.List;

/**
 * 说明： 用户的领域对象
 *
 * @author: dengshuai
 * @date: Created in 10:13 2018/4/8
 * @modified: by autor in 10:13 2018/4/8
 */
public class User extends UserEntity {


    /**
     * 微信账号
     */
    public static final Integer TYPE_5 = 5;

    /**
     * 正常账号状态
     */
    public static final Integer STATE_1 = 1;
    public static final Integer STATE_0 = 0;
    /**
     * 登录成功的secret
     */
    String secret;
    /**
     * //重置密码时必须传的参数
     */
    Boolean resetPwd;

    /**
     * // 用户员工信息
     */
    EmployeeEntity emp;
    /**
     * // 用户机构信息
     */
    OrganizationEntity org;
    /**
     * // 用户部门信息
     */
    DepartmentEntity department;
    /**
     * // 用户真实姓名
     */
    String realName;
    /**
     * // 用户拥有的角色
     */
    List<RoleEntity> roles;
    /**
     * // 用户拥有的权限
     */
    List<RoleprivilegeEntity> privileges;
    /**
     * // 用户的菜单权限
     */
    List<MenuEntity> menuPrivileges;
    /**
     * // 用户功能权限
     */
    List<FuncEntity> funcPrivileges;
    /**
     * // 用户拥有的系统权限
     */
    List<SubsystemEntity> subSystemPrivileges;
    /**
     * //用户当前登录的系统
     */
    SubsystemEntity subsystemEntity;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Boolean getResetPwd() {
        return resetPwd;
    }

    public void setResetPwd(Boolean resetPwd) {
        this.resetPwd = resetPwd;
    }

    public EmployeeEntity getEmp() {
        return emp;
    }

    public void setEmp(EmployeeEntity emp) {
        this.emp = emp;
    }

    public OrganizationEntity getOrg() {
        return org;
    }

    public void setOrg(OrganizationEntity org) {
        this.org = org;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<RoleprivilegeEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<RoleprivilegeEntity> privileges) {
        this.privileges = privileges;
    }

    public List<MenuEntity> getMenuPrivileges() {
        return menuPrivileges;
    }

    public void setMenuPrivileges(List<MenuEntity> menuPrivileges) {
        this.menuPrivileges = menuPrivileges;
    }

    public List<FuncEntity> getFuncPrivileges() {
        return funcPrivileges;
    }

    public void setFuncPrivileges(List<FuncEntity> funcPrivileges) {
        this.funcPrivileges = funcPrivileges;
    }

    public List<SubsystemEntity> getSubSystemPrivileges() {
        return subSystemPrivileges;
    }

    public void setSubSystemPrivileges(List<SubsystemEntity> subSystemPrivileges) {
        this.subSystemPrivileges = subSystemPrivileges;
    }

    public SubsystemEntity getSubsystemEntity() {
        return subsystemEntity;
    }

    public void setSubsystemEntity(SubsystemEntity subsystemEntity) {
        this.subsystemEntity = subsystemEntity;
    }
}
