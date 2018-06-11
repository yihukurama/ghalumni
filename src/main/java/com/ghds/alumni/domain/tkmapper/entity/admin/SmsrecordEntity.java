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
 * 说明： 短信发送记录表
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="短信发送记录表")
@Table(name="admin_smsrecord")
public class SmsrecordEntity extends BaseEntity
{

	/**
	*短信类型 0普通短信;1营销短信
	**/
	@ApiModelProperty(value="短信类型 0普通短信;1营销短信")
	@Column(name="type")
	private Integer type;
	/**
	*逻辑删除状态  0未删除  1已删除
	**/
	@ApiModelProperty(value="逻辑删除状态  0未删除  1已删除")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*短信发送的内容
	**/
	@ApiModelProperty(value="短信发送的内容")
	@Column(name="msg")
	private String msg;
	/**
	*业务回调url
	**/
	@ApiModelProperty(value="业务回调url")
	@Column(name="responseUrl")
	private String responseUrl;
	/**
	*接收方手机号
	**/
	@ApiModelProperty(value="接收方手机号")
	@Column(name="tel")
	private String tel;
	/**
	*标识本次发送id，标识一次短信下发记录
	**/
	@ApiModelProperty(value="标识本次发送id，标识一次短信下发记录")
	@Column(name="sid")
	private String sid;
	/**
	*主状态 1发送成功 2发送失败 3接收成功 4接收失败 
	**/
	@ApiModelProperty(value="主状态 1发送成功 2发送失败 3接收成功 4接收失败 ")
	@Column(name="status")
	private Integer status;
	/**
	*副状态 1反馈成功
	**/
	@ApiModelProperty(value="副状态 1反馈成功")
	@Column(name="costate")
	private Integer costate;
	/**
	*短信模板Id
	**/
	@ApiModelProperty(value="短信模板Id")
	@Column(name="tplId")
	private Integer tplId;
	/**
	*错误原因
	**/
	@ApiModelProperty(value="错误原因")
	@Column(name="reason")
	private String reason;
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


	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	public String getMsg(){
		return msg;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getResponseUrl(){
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl){
		this.responseUrl = responseUrl;
	}

	public String getTel(){
		return tel;
	}

	public void setTel(String tel){
		this.tel = tel;
	}

	public String getSid(){
		return sid;
	}

	public void setSid(String sid){
		this.sid = sid;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getCostate(){
		return costate;
	}

	public void setCostate(Integer costate){
		this.costate = costate;
	}

	public Integer getTplId(){
		return tplId;
	}

	public void setTplId(Integer tplId){
		this.tplId = tplId;
	}

	public String getReason(){
		return reason;
	}

	public void setReason(String reason){
		this.reason = reason;
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

	
	

	
	
}
