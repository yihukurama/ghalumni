package com.ghds.alumni.domain.admin;

import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;

/**
 * 说明： 员工领域对象
 * @author dengshuai
 * @date Created in 16:06 2018/4/20
 * @modified by autor in 16:06 2018/4/20
 */
public class Employee extends EmployeeEntity {

    /**
     * 关联的微信用户
     */
    private WxuserEntity wxuserEntity;

    public WxuserEntity getWxuserEntity() {
        return wxuserEntity;
    }

    public void setWxuserEntity(WxuserEntity wxuserEntity) {
        this.wxuserEntity = wxuserEntity;
    }

    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "realName")
    public String getRealName() {
        return super.getRealName();
    }

    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "note")
    public String getNote() {
        return super.getNote();
    }
}
