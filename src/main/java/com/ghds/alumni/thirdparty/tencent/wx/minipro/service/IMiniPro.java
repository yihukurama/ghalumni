package com.ghds.alumni.thirdparty.tencent.wx.minipro.service;


import com.ghds.alumni.thirdparty.Config;

public interface IMiniPro {

    /**
     * @Description: 获取小程序access_token
     * @Author: dengshuai
     * @Date: Created in 17:36 2018/1/5
     * @Modified: by autor in 17:36 2018/1/5
     * @Reurn access_token
     */
    public String doGetAccessToken(Config config);

    /**
     * @param serveConfig 小程序对应的微信服务号配置
     * @param requestBody path	String	小程序里的页面不能为空，最大长度 128 字节
     *                    width	Int	430	二维码的宽度
     * @return
     * @Description:    获取小程序二维码
     * @Author: dengshuai
     * @Date: Created in 17:33 2018/1/5
     * @Modified: by autor in 17:33 2018/1/5
     */
    public byte[] createwxaqrcode(Config serveConfig, Object requestBody);

    /**
     * 说明： 获取小程序码A接口
     * @author: dengshuai
     * @date: Created in 11:28 2018/3/7
     * @modified: by autor in 11:28 2018/3/7
     * @param requestBody path	String	小程序里的页面不能为空，最大长度 128 字节
     */
    public byte[] createwxacode(Config serveConfig, Object requestBody);

    /**
     * @Description: 根据type值获取配置 1车主  2保险   3辅警   4中心
     * @Author: dengshuai
     * @Date: Created in 18:46 2018/1/8
     * @Modified: by autor in 18:46 2018/1/8
     */
    public Config doGetConfigByType(int type);


    /**
     * @Description: 发送模板消息
     * @Author: dengshuai
     * @Date: Created in 15:50 2018/1/10
     * @Modified: by autor in 15:50 2018/1/10
     *
     * @param serveConfig
     * @param requestBody
     * @return
     */
    public String templatesend(Config serveConfig, Object requestBody);




}
