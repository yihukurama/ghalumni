package com.ghds.alumni.service.businessservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;

public interface IPublicApi {

    /**
     * 登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Result login(Request<User> request) throws TipsException;

    /**
     * //获取短信验证码
     *
     * @param request
     * @return
     */
    public Result doGetSMSCode(Request<String> request);

    /**
     * //获取用户权限
     *
     * @param request
     * @return
     */
    public Result getAuths(Request<User> request);
}
