package com.ghds.alumni.domain.admin;

import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
/**
 * 说明： 员工领域对象
 * @author dengshuai
 * @date Created in 16:06 2018/4/20
 * @modified by autor in 16:06 2018/4/20
 */
public class Employee extends EmployeeEntity {
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "realName")
    public String getRealName() {
        return super.getRealName();
    }
}
