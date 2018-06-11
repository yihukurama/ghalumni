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
 * 说明： 保存公司评估、报价人员数据;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存公司评估、报价人员数据;")
@Table(name="admin_employee")
public class EmployeeEntity extends BaseEntity
{

	/**
	*员工所属机构id
	**/
	@ApiModelProperty(value="员工所属机构id")
	@Column(name="orgId")
	private String orgId;
	/**
	*员工所属部门id
	**/
	@ApiModelProperty(value="员工所属部门id")
	@Column(name="departmentId")
	private String departmentId;
	/**
	*员工编号
	**/
	@ApiModelProperty(value="员工编号")
	@Column(name="code")
	private String code;
	/**
	*员工真实姓名
	**/
	@ApiModelProperty(value="员工真实姓名")
	@Column(name="realName")
	private String realName;
	/**
	*员工手机号码
	**/
	@ApiModelProperty(value="员工手机号码")
	@Column(name="mobile")
	private String mobile;
	/**
	*公司联系电话
	**/
	@ApiModelProperty(value="公司联系电话")
	@Column(name="tel")
	private String tel;
	/**
	*邮箱地址
	**/
	@ApiModelProperty(value="邮箱地址")
	@Column(name="email")
	private String email;
	/**
	*联系地址
	**/
	@ApiModelProperty(value="联系地址")
	@Column(name="address")
	private String address;
	/**
	*状态,0在职,1离职,2停职
	**/
	@ApiModelProperty(value="状态,0在职,1离职,2停职")
	@Column(name="status")
	private Integer status;
	/**
	*入职日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="dateJoined")
	private Date dateJoined;
	/**
	*离职日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="dateLeft")
	private Date dateLeft;
	/**
	*工作年龄
	**/
	@ApiModelProperty(value="工作年龄")
	@Column(name="workAge")
	private Integer workAge;
	/**
	*紧急联系人姓名
	**/
	@ApiModelProperty(value="紧急联系人姓名")
	@Column(name="emContact")
	private String emContact;
	/**
	*紧急联系电话
	**/
	@ApiModelProperty(value="紧急联系电话")
	@Column(name="emTel")
	private String emTel;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="createrId")
	private String createrId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operatorId")
	private String operatorId;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operateDate")
	private Date operateDate;
	/**
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="indexOrder")
	private Integer indexOrder;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*删除状态,0正常,1删除
	**/
	@ApiModelProperty(value="删除状态,0正常,1删除")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*机构名
	**/
	@ApiModelProperty(value="机构名")
	@Column(name="orgName")
	private String orgName;
	/**
	*部门名
	**/
	@ApiModelProperty(value="部门名")
	@Column(name="departmentName")
	private String departmentName;
	/**
	*创建人姓名
	**/
	@ApiModelProperty(value="创建人姓名")
	@Column(name="creater")
	private String creater;
	/**
	*最后更新人姓名
	**/
	@ApiModelProperty(value="最后更新人姓名")
	@Column(name="operator")
	private String operator;
	


	public String getOrgId(){
		return orgId;
	}

	public void setOrgId(String orgId){
		this.orgId = orgId;
	}

	public String getDepartmentId(){
		return departmentId;
	}

	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName = realName;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getTel(){
		return tel;
	}

	public void setTel(String tel){
		this.tel = tel;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Date getDateJoined(){
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined){
		this.dateJoined = dateJoined;
	}

	public Date getDateLeft(){
		return dateLeft;
	}

	public void setDateLeft(Date dateLeft){
		this.dateLeft = dateLeft;
	}

	public Integer getWorkAge(){
		return workAge;
	}

	public void setWorkAge(Integer workAge){
		this.workAge = workAge;
	}

	public String getEmContact(){
		return emContact;
	}

	public void setEmContact(String emContact){
		this.emContact = emContact;
	}

	public String getEmTel(){
		return emTel;
	}

	public void setEmTel(String emTel){
		this.emTel = emTel;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public Date getOperateDate(){
		return operateDate;
	}

	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}

	public Integer getIndexOrder(){
		return indexOrder;
	}

	public void setIndexOrder(Integer indexOrder){
		this.indexOrder = indexOrder;
	}

	public String getNote(){
		return note;
	}

	public void setNote(String note){
		this.note = note;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	public String getOrgName(){
		return orgName;
	}

	public void setOrgName(String orgName){
		this.orgName = orgName;
	}

	public String getDepartmentName(){
		return departmentName;
	}

	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}

	public String getCreater(){
		return creater;
	}

	public void setCreater(String creater){
		this.creater = creater;
	}

	public String getOperator(){
		return operator;
	}

	public void setOperator(String operator){
		this.operator = operator;
	}

	
	

	
	
}
