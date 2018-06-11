package com.ghds.alumni.thirdparty.tencent.wx.minipro;

import com.ghds.alumni.thirdparty.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 小程序个人版的基础配置
 * @Author: dengshuai
 * @Date: Created in 13:58 2018/1/5
 * @Modified: by autor in 13:58 2018/1/5
 */
@ConfigurationProperties(prefix = "MiniProPersonalConfig")
@Configuration
public class MiniProPersonalConfig extends Config {
}

