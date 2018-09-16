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
 * 说明： 系统用户与腾讯用户的关联表，关联UnionId
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="系统用户与腾讯用户的关联表，关联UnionId")
@Table(name="business_wxuser")
public class WxuserEntity extends BaseEntity
{

	/**
	*1呈信出行
	**/
	@ApiModelProperty(value="1呈信出行")
	@Column(name="type")
	private Integer type;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
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
	*唯一Id
	**/
	@ApiModelProperty(value="唯一Id")
	@Column(name="unionid")
	private String unionid;
	/**
	*小程序openId
	**/
	@ApiModelProperty(value="小程序openId")
	@Column(name="perOpenId")
	private String perOpenId;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="userId")
	private String userId;
	/**
	*昵称
	**/
	@ApiModelProperty(value="昵称")
	@Column(name="nickName")
	private String nickName;
	/**
	*性别  1男 2女
	**/
	@ApiModelProperty(value="性别  1男 2女")
	@Column(name="gender")
	private Integer gender;
	/**
	*偶像地址
	**/
	@ApiModelProperty(value="偶像地址")
	@Column(name="avatarUrl")
	private String avatarUrl;
	/**
	*城市
	**/
	@ApiModelProperty(value="城市")
	@Column(name="city")
	private String city;
	/**
	*国家
	**/
	@ApiModelProperty(value="国家")
	@Column(name="country")
	private String country;
	/**
	*省份
	**/
	@ApiModelProperty(value="省份")
	@Column(name="province")
	private String province;
	/**
	*delStatus
	**/
	@ApiModelProperty(value="delStatus")
	@Column(name="delStatus")
	private Integer delStatus;
	/**
	*0未认证  1已认证
	**/
	@ApiModelProperty(value="0未认证  1已认证")
	@Column(name="auth")
	private Boolean auth;
	/**
	*职业
	**/
	@ApiModelProperty(value="职业")
	@Column(name="occupation")
	private String occupation;
	/**
	*学校名称
	**/
	@ApiModelProperty(value="学校名称")
	@Column(name="schoolName")
	private String schoolName;
	/**
	*公司名称
	**/
	@ApiModelProperty(value="公司名称")
	@Column(name="companyName")
	private String companyName;
	/**
	*1不允许搜索  2允许认证校友搜索  3允许所有人搜索
	**/
	@ApiModelProperty(value="1不允许搜索  2允许认证校友搜索  3允许所有人搜索")
	@Column(name="privacyLevel")
	private Integer privacyLevel;
	/**
	*当前所在地址
	**/
	@ApiModelProperty(value="当前所在地址")
	@Column(name="nowAddr")
	private String nowAddr;
	/**
	*realName
	**/
	@ApiModelProperty(value="realName")
	@Column(name="realName")
	private String realName;
	/**
	*届别
	**/
	@ApiModelProperty(value="届别")
	@Column(name="workAge")
	private Integer workAge;
	
	

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

	public Boolean getAuth(){
		return auth;
	}

	public void setAuth(Boolean auth){
		this.auth = auth;
	}

	public String getOccupation(){
		return occupation;
	}

	public void setOccupation(String occupation){
		this.occupation = occupation;
	}

	public String getSchoolName(){
		return schoolName;
	}

	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public Integer getPrivacyLevel(){
		return privacyLevel;
	}

	public void setPrivacyLevel(Integer privacyLevel){
		this.privacyLevel = privacyLevel;
	}

	public String getNowAddr(){
		return nowAddr;
	}

	public void setNowAddr(String nowAddr){
		this.nowAddr = nowAddr;
	}

	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName = realName;
	}

	public Integer getWorkAge(){
		return workAge;
	}

	public void setWorkAge(Integer workAge){
		this.workAge = workAge;
	}

	
	

	
	
}
