package com.ghds.alumni.thirdparty.tencent.wx.minipro.model;

import java.io.Serializable;

/**
 * AccessToken
 * domain
 * 微信调用接口凭证 实体类
 * @author lilongjun
 * @date 2016-10-13 xx:xx:xx
 */
public class AccessToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String access_token; //accessToken 凭证ID
	private String expires_in; //凭证有效时间
	
	/** getset() */
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	
	
	
}
