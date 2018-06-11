package com.ghds.alumni.domain.admin;

import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.app.constant.MagicCode;
import com.ghds.alumni.domain.tkmapper.entity.admin.MenuEntity;

import java.util.Date;

/**
 * 说明： 菜单领域对象
 *
 * @author dengshuai
 * @date Created in 9:47 2018/4/13
 * @modified by autor in 9:47 2018/4/13
 */
public class Menu extends MenuEntity {

    private String createDateGTE;
    private String createDateLTE;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GTE,proprtityName = MagicCode.CREATEDATE)
    public String getCreateDateGTE() {
        return createDateGTE;
    }

    public void setCreateDateGTE(String createDateGTE) {
        this.createDateGTE = createDateGTE;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LTE,proprtityName = MagicCode.CREATEDATE)
    public String getCreateDateLTE() {
        return createDateLTE;
    }

    public void setCreateDateLTE(String createDateLTE) {
        this.createDateLTE = createDateLTE;
    }





}
