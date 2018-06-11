package com.ghds.alumni.service.businessservice.business;

import com.alibaba.fastjson.JSONObject;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;

public interface IWechat {

    /**
     * 说明： 发送微信小程序模板消息
     * @author: ouyaokun
     * @date: Created in 10:03 2018/5/8
     * @modified: by autor in 10:03 2018/5/8
     */
    public Result sendPerMiniMsg(JSONObject template, String openId) throws TipsException;

    /**
     * 说明： 使用openId登录系统
     * @author: ouyaokun
     * @date: Created in 10:04 2018/5/8
     * @modified: by autor in 10:04 2018/5/8
     */
    public Result loginByOpenId(Request<Wxuser> request) throws TipsException;
}
