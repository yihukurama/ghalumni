package com.ghds.alumni.app.config;

/**
 * 功能描述:字符串占位符s%拼接的配置
 *
 * @Author: 蔡伟浩
 * @Date: 2017/1/13 14:36
 */
public final class StringConfig {

    //文件名称格式 %s时间字符串 %s随机加密字符串 %.后缀
    public static final String FILE_NAME_FORMAT_STRING = "gdyunst_%s_%s_%s";

    //下载微信图片具体链接 %s下载微信图片域名 %s微信mediaId
    public static final String WECHAT_DOWNLOAD_URL_FORMAT = "%s/downLoad/shotMedia?mediaId=%s";


    //上传车牌识别错误次数key
    public static String REDIS_UPLOAD_PLATE_DISCERN_ERROR_COUNT_BY_PHONE_CARINDEX = "redis_upload_plate_discern_error_count_by_%s_%s";
}
