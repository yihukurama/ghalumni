package com.ghds.alumni.domain.business;


import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.domain.tkmapper.entity.business.TagsEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;

import java.util.List;

/**
 * 说明： Wxuser领域对象
 * @author: ouyaokun
 * @date: Created in 9:45 2018/5/8
 * @modified: by autor in 9:45 2018/5/8
 */
public class Wxuser extends WxuserEntity {

    /**
     * 私密
     */
    public static final int PRIVACELEVEL_1 = 1;
    /**
     * 认证校友
     */
    public static final int PRIVACELEVEL_2 = 2;
    /**
     * 公开
     */
    public static final int PRIVACELEVEL_3 = 3;


    private List<TagsEntity> tagsEntityList;

    public List<TagsEntity> getTagsEntityList() {
        return tagsEntityList;
    }

    public void setTagsEntityList(List<TagsEntity> tagsEntityList) {
        this.tagsEntityList = tagsEntityList;
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "realName")
    public String getRealName() {
        return super.getRealName();
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "schoolName")
    public String getSchoolName(){
        return super.getSchoolName();
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "companyName")
    public String getCompanyName(){
        return super.getCompanyName();
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "nowAddr")
    public String getNowAddr(){
        return super.getNowAddr();
    }



}
