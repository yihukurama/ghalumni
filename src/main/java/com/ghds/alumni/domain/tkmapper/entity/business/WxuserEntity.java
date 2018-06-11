package com.ghds.alumni.domain.tkmapper.entity.business;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明： 系统用户与腾讯用户的关联表，关联UnionId
 * @author: ouyaokun
 * @date: Created in 9:42 2018/5/8
 * @modified: by autor in 9:42 2018/5/8
 */
@Table(name="business_wxuser")
public class WxuserEntity extends BaseEntity
{

	/**
	*1呈信出行
	**/
	@Column(name="type")
	private Integer type;

	/**
	*备注信息
	**/
	@Column(name="note")
	private String note;

	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@Column(name="createDate")
	private Date createDate;

	/**
	*最后修改时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@Column(name="operateDate")
	private Date operateDate;

	/**
	*创建人Id
	**/
	@Column(name="createrId")
	private String createrId;

	/**
	*创建人姓名
	**/
	@Column(name="creater")
	private String creater;

	/**
	*最后更新人Id
	**/
	@Column(name="operatorId")
	private String operatorId;

	/**
	*最后更新人姓名
	**/
	@Column(name="operator")
	private String operator;

	/**
	*唯一Id
	**/
	@Column(name="unionid")
	private String unionid;

	/**
	*车主版小程序openId
	**/
	@Column(name="perOpenId")
	private String perOpenId;

	/**
	*用户id
	**/
	@Column(name="userId")
	private String userId;

	/**
	*昵称
	**/
	@Column(name="nickName")
	private String nickName;

	/**
	*性别  1男 2女
	**/
	@Column(name="gender")
	private Integer gender;

	/**
	*头像地址
	**/
	@Column(name="avatarUrl")
	private String avatarUrl;

	/**
	*城市
	**/
	@Column(name="city")
	private String city;

	/**
	*国家
	**/
	@Column(name="country")
	private String country;

	/**
	*省份
	**/
	@Column(name="province")
	private String province;

	/**
	*delStatus
	**/
	@Column(name="delStatus")
	private Integer delStatus;

	@Column(name="auth")
	private Boolean auth;

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public String getNote(){
		return note;
	}

	public void setNote(String note){
		this.note = note;
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

	public String getUnionid(){
		return unionid;
	}

	public void setUnionid(String unionid){
		this.unionid = unionid;
	}

	public String getPerOpenId(){
		return perOpenId;
	}

	public void setPerOpenId(String perOpenId){
		this.perOpenId = perOpenId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getNickName(){
		return nickName;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public Integer getGender(){
		return gender;
	}

	public void setGender(Integer gender){
		this.gender = gender;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCountry(){
		return country;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getProvince(){
		return province;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public Integer getDelStatus(){
		return delStatus;
	}

	public void setDelStatus(Integer delStatus){
		this.delStatus = delStatus;
	}

	
	

	
	
}
