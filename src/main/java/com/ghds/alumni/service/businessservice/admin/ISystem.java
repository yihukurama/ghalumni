package com.ghds.alumni.service.businessservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.web.dto.CacheDto;
import com.ghds.alumni.web.dto.ChangePasswordRequest;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;

/**
 * @Description: 系统服务
 * @Author: dengshuai
 * @Date: Created in 17:56 2018/1/16
 * @Modified: by autor in 17:56 2018/1/16
 */
public interface ISystem {
    /**
     * @Description: 清除缓存
     * @Author: dengshuai
     * @Date: Created in 17:55 2018/1/16
     * @Modified: by autor in 17:55 2018/1/16
     */
    public Result cleanCache(CacheDto cacheDto);

    /**
     * @Description: 修改密码
     * @Author: dengshuai
     * @Date: Created in 11:44 2018/1/17
     * @Modified: by autor in 11:44 2018/1/17
     */
    Result changePassword(ChangePasswordRequest cpRequest) throws TipsException;

    /**
     * @Description: 退出登录
     * @Author: dengshuai
     * @Date: Created in 11:44 2018/1/17
     * @Modified: by autor in 11:44 2018/1/17
     */
    Result logout(Request<User> request);
}
