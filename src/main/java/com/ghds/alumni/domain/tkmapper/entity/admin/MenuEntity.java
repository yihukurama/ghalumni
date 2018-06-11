package com.ghds.alumni.domain.tkmapper.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 说明： 保存系统菜单数据;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存系统菜单数据;")
@Table(name="admin_menu")
public class MenuEntity extends BaseEntity
{

	/**
	*菜单所属子系统id
	**/
	@ApiModelProperty(value="菜单所属子系统id")
	@Column(name="subSystemId")
	private String subSystemId;
	/**
	*父级菜单id,该值为root代表菜单为一级菜单
	**/
	@ApiModelProperty(value="父级菜单id,该值为root代表菜单为一级菜单")
	@Column(name="parentId")
	private String parentId;
	/**
	*分层路径
	**/
	@ApiModelProperty(value="分层路径")
	@Column(name="path")
	private String path;
	/**
	*菜单编码
	**/
	@ApiModelProperty(value="菜单编码")
	@Column(name="code")
	private String code;
	/**
	*菜单名称
	**/
	@ApiModelProperty(value="菜单名称")
	@Column(name="text")
	private String text;
	/**
	*extjs链接
	**/
	@ApiModelProperty(value="extjs链接")
	@Column(name="linkUrl")
	private String linkUrl;
	/**
	*菜单接口地址
	**/
	@ApiModelProperty(value="菜单接口地址")
	@Column(name="serverUrl")
	private String serverUrl;
	/**
	*图标样式
	**/
	@ApiModelProperty(value="图标样式")
	@Column(name="iconClass")
	private String iconClass;
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
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="indexOrder")
	private Integer indexOrder;
	/**
	*所属系统名
	**/
	@ApiModelProperty(value="所属系统名")
	@Column(name="subSystemName")
	private String subSystemName;
	


	public String getSubSystemId(){
		return subSystemId;
	}

	public void setSubSystemId(String subSystemId){
		this.subSystemId = subSystemId;
	}

	public String getParentId(){
		return parentId;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
	@SqlWhere(value = SqlWhere.SqlWhereValue.LIKE, proprtityName = "text")
	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getLinkUrl(){
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl){
		this.linkUrl = linkUrl;
	}

	public String getServerUrl(){
		return serverUrl;
	}

	public void setServerUrl(String serverUrl){
		this.serverUrl = serverUrl;
	}

	public String getIconClass(){
		return iconClass;
	}

	public void setIconClass(String iconClass){
		this.iconClass = iconClass;
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

	public Integer getIndexOrder(){
		return indexOrder;
	}

	public void setIndexOrder(Integer indexOrder){
		this.indexOrder = indexOrder;
	}

	public String getSubSystemName(){
		return subSystemName;
	}

	public void setSubSystemName(String subSystemName){
		this.subSystemName = subSystemName;
	}

	
	

	
	
}
