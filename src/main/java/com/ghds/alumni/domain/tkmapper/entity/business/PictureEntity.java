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
 * 说明： 图片表
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="图片表")
@Table(name="business_picture")
public class PictureEntity extends BaseEntity
{

	/**
	*图片所关联的id
	**/
	@ApiModelProperty(value="图片所关联的id")
	@Column(name="relateId")
	private String relateId;
	/**
	*图片类型 1普通类型
	**/
	@ApiModelProperty(value="图片类型 1普通类型")
	@Column(name="type")
	private Integer type;
	/**
	*图片路径
	**/
	@ApiModelProperty(value="图片路径")
	@Column(name="filePath")
	private String filePath;
	/**
	*图片序号
	**/
	@ApiModelProperty(value="图片序号")
	@Column(name="picIndex")
	private Integer picIndex;
	/**
	*删除状态,0未删除,1删除
	**/
	@ApiModelProperty(value="删除状态,0未删除,1删除")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*图片来源：1后台
	**/
	@ApiModelProperty(value="图片来源：1后台")
	@Column(name="origin")
	private Integer origin;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	/**
	*关联类型
	**/
	@ApiModelProperty(value="关联类型")
	@Column(name="relateType")
	private Integer relateType;

	public String getRelateId(){
		return relateId;
	}

	public void setRelateId(String relateId){
		this.relateId = relateId;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public String getFilePath(){
		return filePath;
	}

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}

	public Integer getPicIndex(){
		return picIndex;
	}

	public void setPicIndex(Integer picIndex){
		this.picIndex = picIndex;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	public Integer getOrigin(){
		return origin;
	}

	public void setOrigin(Integer origin){
		this.origin = origin;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Integer getRelateType(){
		return relateType;
	}

	public void setRelateType(Integer relateType){
		this.relateType = relateType;
	}

	
	

	
	
}
