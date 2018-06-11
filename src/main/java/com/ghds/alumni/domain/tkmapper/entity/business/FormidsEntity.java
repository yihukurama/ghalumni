package com.ghds.alumni.domain.tkmapper.entity.business;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明： 微信小程序formid表
 * @author: ouyaokun
 * @date: Created in 9:39 2018/5/7
 * @modified: by autor in 9:39 2018/5/7
 */
@Table(name="business_formids")
public class FormidsEntity extends BaseEntity
{

	/**
	*小程序openId
	**/
	@Column(name="openId")
	private String openId;

	/**
	*小程序formId
	**/
	@Column(name="formId")
	private String formId;

	/**
	*1待使用   2已使用
	**/
	@Column(name="status")
	private Integer status;

	/**
	*删除状态,0未删除,1删除
	**/
	@Column(name="delStatus")
	private Integer delStatus;

	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@Column(name="createDate")
	private Date createDate;

	
	public String getOpenId(){
		return openId;
	}

	public void setOpenId(String openId){
		this.openId = openId;
	}

	public String getFormId(){
		return formId;
	}

	public void setFormId(String formId){
		this.formId = formId;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
