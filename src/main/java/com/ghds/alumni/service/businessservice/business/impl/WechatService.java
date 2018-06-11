package com.ghds.alumni.service.businessservice.business.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghds.alumni.app.cache.RedisUtils;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.security.JwtTokenGenerator;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.business.Formids;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.FormidsEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;
import com.ghds.alumni.service.businessservice.business.IWechat;
import com.ghds.alumni.service.domainservice.admin.UserService;
import com.ghds.alumni.service.domainservice.business.FormidsService;
import com.ghds.alumni.service.domainservice.business.WxuserService;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.MiniProPersonalConfig;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.service.IMiniPro;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 说明：
 * @author: ouyaokun
 * @date: Created in 15:12 2018/5/7
 * @modified: by autor in 15:12 2018/5/7
 */
@Service
public class WechatService implements IWechat {

    @Autowired
    MiniProPersonalConfig personalConfig;
    @Autowired
    IMiniPro iMiniPro;
    @Autowired
    FormidsService formidsService;
    @Autowired
    WxuserService wxuserService;
    @Autowired
    UserService userService;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public Result sendPerMiniMsg(JSONObject template, String openId) throws TipsException {
        JSONObject jsonObject = template;
        jsonObject.replace("touser",openId);

        //设置formId
        Formids formids = new Formids();
        formids.setOpenId(openId);
        String formId = formidsService.doGetFormId(formids);
        jsonObject.replace("form_id",formId);

        String result = iMiniPro.templatesend(personalConfig, jsonObject.toJSONString());
        JSONObject resultObj = JSON.parseObject(result);
        if(EmptyUtil.isEmpty(result) || resultObj==null || !String.valueOf(resultObj.get("errcode")).equals("0")){
            return Result.failed("发送失败"+result);
        }

        //发送完毕后把该formId设为已使用
        formids = new Formids();
        formids.setOpenId(openId);
        formids.setFormId(formId);
        FormidsEntity formidsEntity = formidsService.loadOneByCondition(formids);
        if(formidsEntity == null){
            return Result.failed("formId为" + formId + "的记录未成功设置为已使用");
        }
        FormidsEntity updateFormidsEntity = new FormidsEntity();
        updateFormidsEntity.setId(formidsEntity.getId());
        updateFormidsEntity.setStatus(Formids.STATUS_2);
        formidsService.update(formidsEntity);
        return Result.successed(result, "操作成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result loginByOpenId(Request<Wxuser> request) throws TipsException {
        Wxuser wxuser = request.getData();
        WxuserEntity wxuserEntity = new WxuserEntity();
        wxuserEntity.setPerOpenId(wxuser.getPerOpenId());
        wxuserEntity = wxuserService.loadOneByCondition(wxuserEntity);
        if(wxuserEntity == null){
            WxuserEntity newWxuserEntity = new WxuserEntity();
            newWxuserEntity.setPerOpenId(wxuser.getPerOpenId());
            wxuserEntity = wxuserService.bindNewUser(newWxuserEntity);
        }
        wxuser.setId(wxuserEntity.getId());
        wxuserService.update(wxuser);
        User user = new User();
        user.setId(wxuserEntity.getUserId());
        UserEntity userEntity = userService.load(user);
        if(userEntity == null){
            return Result.failed("该openId绑定的用户不存在");
        }

        String token = JwtTokenGenerator.generateToken(userEntity, new Date().toString());
        UserEntity updateUser = new UserEntity();
        updateUser.setId(userEntity.getId());
        updateUser.setToken(token);
        userService.update(updateUser);
        LogUtil.DebugLog(this,"loginByOpenId=============>"+JSON.toJSONString(updateUser));
        user = userService.doGetUser(updateUser);
        redisUtils.set(user.getId()+ Constant.encryptKey, token, Constant.LOGIN_EXPIRETIME);
        return Result.successed(user,"登录成功");
    }
}
