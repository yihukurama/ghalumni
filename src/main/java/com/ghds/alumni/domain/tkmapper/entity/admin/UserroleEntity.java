package com.ghds.alumni.domain.tkmapper.entity.admin;

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
 * 说明： 保存账号,角色关联数据,一对多关联;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存账号,角色关联数据,一对多关联;")
@Table(name="admin_userrole")
public class UserroleEntity extends BaseEntity
{

	/**
	*账号id
	**/
	@ApiModelProperty(value="账号id")
	@Column(name="userId")
	private String userId;
	/**
	*角色id
	**/
	@ApiModelProperty(value="角色id")
	@Column(name="roleId")
	private String roleId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;


	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getRoleId(){
		return roleId;
	}

	public void setRoleId(String roleId){
		this.roleId = roleId;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
