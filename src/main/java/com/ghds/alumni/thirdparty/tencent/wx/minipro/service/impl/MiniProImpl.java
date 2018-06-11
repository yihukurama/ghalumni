package com.ghds.alumni.thirdparty.tencent.wx.minipro.service.impl;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.cache.RedisUtils;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.thirdparty.Config;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.MiniProPersonalConfig;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.model.AccessToken;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.service.IMiniPro;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.service.IMiniProFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniProImpl implements IMiniPro {


    @Autowired
    IMiniProFeign iMiniProFeign;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    MiniProPersonalConfig miniProPersonalConfig;

    @Override
    public String doGetAccessToken(Config config) {
        //1获取缓存中的token
        String token = (String)redisUtils.get(config.getAppid());
        if(token == null){
            String newtoken = iMiniProFeign.doGetToken(config.getAppid(),config.getKey());
            LogUtil.InfoLog(this,config.getAppid()+":小程序获取新token返回"+newtoken);
            AccessToken newaccessToken = JSON.parseObject(newtoken,AccessToken.class);
            try {
                redisUtils.set(config.getAppid(),newaccessToken.getAccess_token(),(Long.parseLong(newaccessToken.getExpires_in())-60L)/1000);
            }catch (Exception e){
                LogUtil.ErrorLog(this,config.getAppid()+"：缓存token失败");
            }

            if(newaccessToken!=null && newaccessToken.getAccess_token()!=null){
                token = newaccessToken.getAccess_token();
            }
        }
        if(token == null){
            LogUtil.ErrorLog(this,config.getAppid()+"：获取token失败");
        }

        return token;
    }

    @Override
    public byte[] createwxaqrcode(Config serveConfig,Object requestBody) {

        String token = doGetAccessToken(serveConfig);
        if(token == null){
            return null;
        }

        LogUtil.DebugLog(this,"创建小程序二维码请求体是："+requestBody);
        return iMiniProFeign.getwxacodeunlimit(token,requestBody);
    }

    @Override
    public byte[] createwxacode(Config serveConfig, Object requestBody) {
        String token = doGetAccessToken(serveConfig);
        if(token == null){
            return null;
        }

        LogUtil.DebugLog(this,"创建小程序二维码请求体是："+requestBody);
        return iMiniProFeign.getwxacode(token,requestBody);
    }

    @Override
    public Config doGetConfigByType(int type) {
        Config config = null;
        switch(type){
            case 1:
                config = miniProPersonalConfig;
                break;
            case 2:
                break;
            case 3:
                break;


        }
        return config;
    }

    @Override
    public String templatesend(Config serveConfig, Object requestBody) {
        String token = doGetAccessToken(serveConfig);
        if(token == null){
            return null;
        }
        LogUtil.InfoLog(this,"发送小程序模板消息请求体"+requestBody);
        String result = iMiniProFeign.templatesend(token,requestBody);
        LogUtil.InfoLog(this,"发送小程序模板消息返回"+result);
        return result;
    }
}
