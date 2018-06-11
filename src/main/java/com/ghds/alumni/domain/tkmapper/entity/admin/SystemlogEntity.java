package com.ghds.alumni.domain.tkmapper.entity.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明： 保存系统日志数据;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存系统日志数据;")
@Table(name="admin_systemlog")
public class SystemlogEntity extends BaseEntity
{
	/**
	*序列号
	**/
	/**
	*操作员工id
	**/
	@ApiModelProperty(value="操作员工id")
	@Column(name="userId")
	private String userId;
	/**
	*日志内容
	**/
	@ApiModelProperty(value="日志内容")
	@Column(name="content")
	private String content;
	/**
	*访问接口地址
	**/
	@ApiModelProperty(value="访问接口地址")
	@Column(name="url")
	private String url;
	/**
	*接口返回结果
	**/
	@ApiModelProperty(value="接口返回结果")
	@Column(name="requestIP")
	private String requestIP;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*删除状态,0未删除,1删除
	**/
	@ApiModelProperty(value="删除状态,0未删除,1删除")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="createDate")
	private Date createDate;
	/**
	*最后修改时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operateDate")
	private Date operateDate;
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
	/**
	*最后更新人Id
	**/
	@ApiModelProperty(value="最后更新人Id")
	@Column(name="operatorId")
	private String operatorId;
	/**
	*最后更新人姓名
	**/
	@ApiModelProperty(value="最后更新人姓名")
	@Column(name="operator")
	private String operator;
	/**
	*result
	**/
	@ApiModelProperty(value="result")
	@Column(name="result")
	private String result;
	
	

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getRequestIP(){
		return requestIP;
	}

	public void setRequestIP(String requestIP){
		this.requestIP = requestIP;
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

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getOperateDate(){
		return operateDate;
	}

	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
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

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public String getOperator(){
		return operator;
	}

	public void setOperator(String operator){
		this.operator = operator;
	}

	public String getResult(){
		return result;
	}

	public void setResult(String result){
		this.result = result;
	}

	
	

	
	
}
