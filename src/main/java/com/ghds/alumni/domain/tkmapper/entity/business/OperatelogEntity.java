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
 * 说明： 操作记录表
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="操作记录表")
@Table(name="business_operatelog")
public class OperatelogEntity extends BaseEntity
{

	/**
	*关联id
	**/
	@ApiModelProperty(value="关联id")
	@Column(name="relateId")
	private String relateId;
	/**
	*类型 
	**/
	@ApiModelProperty(value="类型 ")
	@Column(name="type")
	private String type;
	/**
	*操作人id
	**/
	@ApiModelProperty(value="操作人id")
	@Column(name="creater")
	private String creater;
	/**
	*处理人真实姓名
	**/
	@ApiModelProperty(value="处理人真实姓名")
	@Column(name="realName")
	private String realName;
	/**
	*处理时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	/**
	*删除状态,0未读取，1已经读取
	**/
	@ApiModelProperty(value="删除状态,0未读取，1已经读取")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*操作结果
	**/
	@ApiModelProperty(value="操作结果")
	@Column(name="result")
	private Boolean result;


	public String getRelateId(){
		return relateId;
	}

	public void setRelateId(String relateId){
		this.relateId = relateId;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getCreater(){
		return creater;
	}

	public void setCreater(String creater){
		this.creater = creater;
	}

	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName = realName;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	public Boolean getResult(){
		return result;
	}

	public void setResult(Boolean result){
		this.result = result;
	}

	
	

	
	
}
