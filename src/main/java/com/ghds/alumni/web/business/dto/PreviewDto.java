package com.ghds.alumni.web.business.dto;

import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.TagsEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;

import java.util.List;

/**
 * 校友详情页信息包装
 */
public class PreviewDto {


    private WxuserEntity wxuserEntity;
    private EmployeeEntity employeeEntity;
    List<TagsEntity> tagsEntityList;

    public List<TagsEntity> getTagsEntityList() {
        return tagsEntityList;
    }

    public void setTagsEntityList(List<TagsEntity> tagsEntityList) {
        this.tagsEntityList = tagsEntityList;
    }

    public WxuserEntity getWxuserEntity() {
        return wxuserEntity;
    }

    public void setWxuserEntity(WxuserEntity wxuserEntity) {
        this.wxuserEntity = wxuserEntity;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
