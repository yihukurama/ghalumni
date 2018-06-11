package com.ghds.alumni.service.businessservice.business;

import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;

/**
 * 说明： 业务公开接口
 * @author dengshuai
 * @date Created in 9:54 2018/5/15
 * @modified by autor in 9:54 2018/5/15
 */
public interface IPublicBus {

    /**
     * 说明： 微信用户绑定
     * @author dengshuai
     * @date Created in 9:55 2018/5/15
     * @modified by autor in 9:55 2018/5/15
     */
    Result bindWxUser(Request<Wxuser> wxuserRequest);
}
