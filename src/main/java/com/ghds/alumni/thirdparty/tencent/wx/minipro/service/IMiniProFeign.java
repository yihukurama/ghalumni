package com.ghds.alumni.thirdparty.tencent.wx.minipro.service;

import com.ghds.alumni.app.utils.LogUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 小程序接口
 * @Author: dengshuai
 * @Date: Created in 9:53 2018/1/8
 * @Modified: by autor in 9:53 2018/1/8
 */
@FeignClient(name = "minPro", url = "https://api.weixin.qq.com", fallback = IMiniProFeign.MinProFeignCallBack.class)
public interface IMiniProFeign {


    @RequestMapping(value = "/cgi-bin/token?grant_type=client_credential", method = RequestMethod.GET)
    public abstract String doGetToken(@RequestParam(value = "appid") String appid,
                                      @RequestParam(value = "secret") String secret);

	@RequestMapping(value = "/sns/jscode2session", method = RequestMethod.POST)
	public abstract String jscode2session(@RequestParam(value = "appid") String appid,
                                          @RequestParam(value = "secret") String secret,
                                          @RequestParam(value = "js_code") String js_code,
                                          @RequestParam(value = "grant_type") String grant_type);

    @RequestMapping(value = "/cgi-bin/wxaapp/createwxaqrcode", method = RequestMethod.POST)
    public abstract byte[] createwxaqrcode(@RequestParam(value = "access_token") String access_token,
                                           @RequestBody Object requestBody);

    @RequestMapping(value = "/cgi-bin/message/wxopen/template/send", method = RequestMethod.POST)
    public abstract String templatesend(@RequestParam(value = "access_token") String access_token,
                                        @RequestBody Object requestBody);

    @RequestMapping(value = "/wxa/getwxacodeunlimit", method = RequestMethod.POST)
    public abstract byte[] getwxacodeunlimit(@RequestParam(value = "access_token") String access_token,
                                             @RequestBody Object requestBody);

    @RequestMapping(value = "/wxa/getwxacode", method = RequestMethod.POST)
    public abstract byte[] getwxacode(@RequestParam(value = "access_token") String access_token,
                                      @RequestBody Object requestBody);
	@Component
	static class MinProFeignCallBack implements IMiniProFeign{

        @Override
        public String doGetToken(String appid, String secret) {
            LogUtil.ErrorLog(this, "小程序获取token失败");
            return "小程序获取token失败";
        }

        @Override
        public String jscode2session(String appid, String secret, String js_code, String authorization_code) {
            LogUtil.ErrorLog(this, "小程序获取session失败");
            return "小程序获取session失败";
        }

        @Override
        public byte[] createwxaqrcode(String access_token, Object requestBody) {
            LogUtil.ErrorLog(this, "获取小程序二维码失败");
            return null;
        }

        @Override
        public String templatesend(String access_token, Object requestBody) {
            LogUtil.ErrorLog(this, "发送模板消息失败");
            return null;
        }

        @Override
        public byte[] getwxacodeunlimit(String access_token, Object requestBody) {
            LogUtil.ErrorLog(this, "获取小程序二维码B接口失败");
            return null;
        }

        @Override
        public byte[] getwxacode(String access_token, Object requestBody) {
            LogUtil.ErrorLog(this, "获取小程序码A接口失败");
            return null;
        }


    }
}
