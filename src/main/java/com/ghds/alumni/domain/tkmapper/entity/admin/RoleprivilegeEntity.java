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
 * 说明： 保存角色拥有权限数据,即角色可访问子系统,菜单,功能数据;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存角色拥有权限数据,即角色可访问子系统,菜单,功能数据;")
@Table(name="admin_roleprivilege")
public class RoleprivilegeEntity extends BaseEntity
{

	/**
	*子系统id
	**/
	@ApiModelProperty(value="子系统id")
	@Column(name="subSystemId")
	private String subSystemId;
	/**
	*菜单/功能id
	**/
	@ApiModelProperty(value="菜单/功能id")
	@Column(name="privilegeId")
	private String privilegeId;
	/**
	*角色id
	**/
	@ApiModelProperty(value="角色id")
	@Column(name="roleId")
	private String roleId;
	/**
	*权限类型,1系统,3菜单,4功能
	**/
	@ApiModelProperty(value="权限类型,1系统,3菜单,4功能")
	@Column(name="type")
	private Integer type;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	


	public String getSubSystemId(){
		return subSystemId;
	}

	public void setSubSystemId(String subSystemId){
		this.subSystemId = subSystemId;
	}

	public String getPrivilegeId(){
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId){
		this.privilegeId = privilegeId;
	}

	public String getRoleId(){
		return roleId;
	}

	public void setRoleId(String roleId){
		this.roleId = roleId;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
