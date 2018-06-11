package com.ghds.alumni.web.business;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.service.businessservice.business.IPublicBus;
import com.ghds.alumni.service.businessservice.business.IWechat;
import com.ghds.alumni.thirdparty.Config;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.service.IMiniPro;
import com.ghds.alumni.thirdparty.tencent.wx.minipro.service.IMiniProFeign;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business/public/api")
@Api(value = "/business/public/api", description = "公开的业务api接口")
public class PublicApiBus {

    @Autowired
    IPublicBus iPublicBus;
    @Autowired
    IMiniPro iMiniPro;
    @Autowired
    IMiniProFeign miniProFeign;
    @Autowired
    IWechat wechatService;

    @ApiOperation(httpMethod = "GET", value = "判断用户是否登录", notes = "判断用户是否登录")
    @RequestMapping(value = "/bindWxUser", method = RequestMethod.POST)
    public Result bindWxUser(@RequestBody Request<Wxuser> request) {
        Wxuser wxuser = request.getData();
        if(EmptyUtil.isEmpty(wxuser.getPerOpenId())){
            return Result.failed("绑定失败,无法获取openId");
        }



        return iPublicBus.bindWxUser(request);
    }


    @ApiOperation(httpMethod = "POST", value = "使用openId登录", notes = "使用openId登录")
    @RequestMapping(value = "/loginByOpenId", method = RequestMethod.POST)
    public Result loginByOpenId(@RequestBody Request<Wxuser> request) throws TipsException
    {

        if(request.getData() == null){
            return Result.failed("参数data为空");
        }
        if(EmptyUtil.isEmpty(request.getData().getPerOpenId())){
            return Result.failed("参数data.perOpenId为空");
        }
        return wechatService.loginByOpenId(request);
    }


    @ApiOperation(httpMethod = "GET", value = "code换session", notes = "code换session")
    @RequestMapping(value = "/jscode2session", method = RequestMethod.GET)
    public String jscode2session(@RequestParam(value="code",required = true) String code,
                                 @RequestParam(value="type",required = true) int type) {

        Config config = iMiniPro.doGetConfigByType(type);
        return miniProFeign.jscode2session(config.getAppid(), config.getKey(), code, "authorization_code");
    }

}
