package com.ghds.alumni.thirdparty;
/**
 * @Description: 第三方服务的配置基类
 * @Author: dengshuai
 * @Date: Created in 9:36 2018/1/5
 * @Modified: by autor in 9:36 2018/1/5
 */
public class Config {
    protected String appid;
    protected String key;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
