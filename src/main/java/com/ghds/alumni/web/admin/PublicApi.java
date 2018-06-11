package com.ghds.alumni.web.admin;

import com.ghds.alumni.app.cache.RedisUtils;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.service.businessservice.admin.IPublicApi;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api")
@Api(value = "/public/api", description = "公开的api接口")
public class PublicApi {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    IPublicApi publicApiService;

    @ApiOperation(httpMethod = "GET", value = "判断用户是否登录", notes = "判断用户是否登录")
    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    public Result isLogin(@RequestParam(value="uid",required = true) String uid) {

        Boolean exists = redisUtils.exists(uid+ Constant.encryptKey);

        if(exists){
            return Result.successed(exists);
        }

        return Result.failed();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<User> request) throws Exception {


        return publicApiService.login(request);
    }


    @RequestMapping(value = "/getAuths", method = RequestMethod.POST)
    public Result getAuths(@RequestBody Request<User> request) {

        return publicApiService.getAuths(request);
    }

}
