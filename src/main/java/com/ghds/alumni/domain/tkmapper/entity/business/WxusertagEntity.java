package com.ghds.alumni.domain.tkmapper.entity.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 说明： 微信用户标签关联表
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="微信用户标签关联表")
@Table(name="business_wxusertag")
public class WxusertagEntity extends BaseEntity
{
	/**
	*id
	**/
	@Id
	private String id;
	/**
	*tagId
	**/
	@ApiModelProperty(value="tagId")
	@Column(name="tagId")
	private String tagId;
	/**
	*wxUserId
	**/
	@ApiModelProperty(value="wxUserId")
	@Column(name="wxUserId")
	private String wxUserId;
	
	

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getTagId(){
		return tagId;
	}

	public void setTagId(String tagId){
		this.tagId = tagId;
	}

	public String getWxUserId(){
		return wxUserId;
	}

	public void setWxUserId(String wxUserId){
		this.wxUserId = wxUserId;
	}

	
	

	
	
}
