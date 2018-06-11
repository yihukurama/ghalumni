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
 * 说明： 保存员工,网点关联数据,一对多关联;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存员工,网点关联数据,一对多关联;")
@Table(name="admin_empservbranch")
public class EmpservbranchEntity extends BaseEntity
{

	/**
	*网点id
	**/
	@ApiModelProperty(value="网点id")
	@Column(name="serviceBranchId")
	private String serviceBranchId;
	/**
	*员工id
	**/
	@ApiModelProperty(value="员工id")
	@Column(name="employeeId")
	private String employeeId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	/**
	*创建人Id
	**/
	@ApiModelProperty(value="创建人Id")
	@Column(name="createrId")
	private String createrId;
	/**
	*创建人姓名
	**/
	@ApiModelProperty(value="创建人姓名")
	@Column(name="creater")
	private String creater;
	


	public String getServiceBranchId(){
		return serviceBranchId;
	}

	public void setServiceBranchId(String serviceBranchId){
		this.serviceBranchId = serviceBranchId;
	}

	public String getEmployeeId(){
		return employeeId;
	}

	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}

	public String getCreater(){
		return creater;
	}

	public void setCreater(String creater){
		this.creater = creater;
	}

	
	

	
	
}
