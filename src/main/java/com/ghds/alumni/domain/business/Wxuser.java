package com.ghds.alumni.domain.business;


import com.ghds.alumni.app.component.annotation.SqlOrderBy;
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

    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "realName")
    public String getRealName() {
        return super.getRealName();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "schoolName")
    public String getSchoolName(){
        return super.getSchoolName();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "companyName")
    public String getCompanyName(){
        return super.getCompanyName();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "nowAddr")
    public String getNowAddr(){
        return super.getNowAddr();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "occupation")
    public String getOccupation(){
        return super.getOccupation();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "departmentText")
    public String getDepartmentText(){
        return super.getDepartmentText();
    }
    @Override
    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "profile")
    public String getProfile(){
        return super.getProfile();
    }


    @SqlOrderBy(value = "auth desc,createDate desc")
    public void setOrderByStr(){

    }

    private String tagText;

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }
}
