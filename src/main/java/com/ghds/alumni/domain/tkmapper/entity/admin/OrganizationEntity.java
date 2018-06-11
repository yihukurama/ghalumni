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
 * 说明： 保存评估机构数据;
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@ApiModel(value="保存评估机构数据;")
@Table(name="admin_organization")
public class OrganizationEntity extends BaseEntity
{

	/**
	*父级机构id,默认为root,该机构为一级机构
	**/
	@ApiModelProperty(value="父级机构id,默认为root,该机构为一级机构")
	@Column(name="parentId")
	private String parentId;
	/**
	*分层路径
	**/
	@ApiModelProperty(value="分层路径")
	@Column(name="path")
	private String path;
	/**
	*机构编码
	**/
	@ApiModelProperty(value="机构编码")
	@Column(name="code")
	private String code;
	/**
	*机构名称
	**/
	@ApiModelProperty(value="机构名称")
	@Column(name="text")
	private String text;
	/**
	*机构所在区域id
	**/
	@ApiModelProperty(value="机构所在区域id")
	@Column(name="areaId")
	private String areaId;
	/**
	*机构所在区域地址
	**/
	@ApiModelProperty(value="机构所在区域地址")
	@Column(name="areaText")
	private String areaText;
	/**
	*机构所在地详细地址
	**/
	@ApiModelProperty(value="机构所在地详细地址")
	@Column(name="address")
	private String address;
	/**
	*联系电话
	**/
	@ApiModelProperty(value="联系电话")
	@Column(name="tel")
	private String tel;
	/**
	*机构负责人id
	**/
	@ApiModelProperty(value="机构负责人id")
	@Column(name="principalId")
	private String principalId;
	/**
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="indexOrder")
	private Integer indexOrder;
	/**
	*机构所在地经度
	**/
	@ApiModelProperty(value="机构所在地经度")
	@Column(name="lng")
	private Double lng;
	/**
	*机构所在地纬度
	**/
	@ApiModelProperty(value="机构所在地纬度")
	@Column(name="lat")
	private Double lat;
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

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getAreaId(){
		return areaId;
	}

	public void setAreaId(String areaId){
		this.areaId = areaId;
	}

	public String getAreaText(){
		return areaText;
	}

	public void setAreaText(String areaText){
		this.areaText = areaText;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getTel(){
		return tel;
	}

	public void setTel(String tel){
		this.tel = tel;
	}

	public String getPrincipalId(){
		return principalId;
	}

	public void setPrincipalId(String principalId){
		this.principalId = principalId;
	}

	public Integer getIndexOrder(){
		return indexOrder;
	}

	public void setIndexOrder(Integer indexOrder){
		this.indexOrder = indexOrder;
	}

	public Double getLng(){
		return lng==null?0.0:lng;
	}

	public void setLng(Double lng){
		this.lng = lng==null?0.0:lng;
	}

	public Double getLat(){
		return lat==null?0.0:lat;
	}

	public void setLat(Double lat){
		this.lat = lat==null?0.0:lat;
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

	
	

	
	
}
