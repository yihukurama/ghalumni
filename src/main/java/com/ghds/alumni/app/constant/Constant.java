package com.ghds.alumni.app.constant;

import java.util.List;

/**
 * 说明： 一些常量
 * @author dengshuai
 * @date Created in 16:14 2018/4/13
 * @modified by autor in 16:14 2018/4/13
 */
public final class Constant {
    /**
     * 配置中接口请求授权UID,程序启动时加载
     */
    public static List<String> AUTHORID;

    /**
     * 数据库中逻辑删除字段
     */
    public static String DEL_STATUS = "delStatus";
    /**
     * 逻辑删除
     */
    public static final int DEL_STATUS_1 = 1;
    /**
     * 逻辑未删除
     */
    public static final int DEL_STATUS_0 = 0;
    /**
     * //用于加密的密钥不同系统不同，避免撞库
     */
    public static final String encryptKey = "ysttkmapper";
    /**
     * //token密钥
     */
    public static final String JWTSECRET = "com.gdyunst";

    /**
     * // 登录有效时间28800秒,8个小时
     */
    public static Long LOGIN_EXPIRETIME = 28800L;

    /**
     * admin领域对象包路径
     */
    public static String packageAdminDomain = "com.ghds.alumni.domain.admin.";
    /**
     * admin mapper包路径
     */
    public static String packageAdminMapper = "com.ghds.alumni.domain.tkmapper.mapper.admin.";
    /**
     * admin领域服务路径
     */
    public static String packageAdminDomainService = "com.ghds.alumni.service.domainservice.admin.";
    /**
     * business领域对象包路径
     */
    public static String packageBusinessDomain = "com.ghds.alumni.domain.business.";
    /**
     * business领域服务路径
     */
    public static String packageBusinessDomainService = "com.ghds.alumni.service.domainservice.business.";
    /**
     * business mapper包路径
     */
    public static String packageBusinessMapper = "com.ghds.alumni.domain.tkmapper.mapper.business.";

}
