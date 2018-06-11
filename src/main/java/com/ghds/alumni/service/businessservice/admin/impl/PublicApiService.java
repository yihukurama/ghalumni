package com.ghds.alumni.service.businessservice.admin.impl;

import com.ghds.alumni.app.cache.AppCache;
import com.ghds.alumni.app.cache.RedisUtils;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.security.JwtTokenGenerator;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.EncrUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.tkmapper.entity.admin.SubsystemEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.service.businessservice.admin.IPublicApi;
import com.ghds.alumni.service.businessservice.admin.ISecurity;
import com.ghds.alumni.service.domainservice.admin.SubsystemService;
import com.ghds.alumni.service.domainservice.admin.UserService;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class PublicApiService implements IPublicApi {

    @Autowired
    ISecurity securityService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    SubsystemService subsystemService;
    @Autowired
    UserService userService;

    @Transactional
    @Override
    public Result login(Request<User> request) throws TipsException {
        UserEntity user = request.getData();
        SubsystemEntity currentSubsystem = request.getData().getSubsystemEntity();
        if (currentSubsystem == null || EmptyUtil.isEmpty(currentSubsystem.getCode())) {
            return Result.failed("参数错误，请检查要登录的系统编号");
        }
        SubsystemEntity loginSubsystem = new SubsystemEntity();
        loginSubsystem.setCode(currentSubsystem.getCode());
        loginSubsystem = subsystemService.loadOneByCondition(loginSubsystem);
        if (loginSubsystem == null) {
            return Result.failed("无此系统");
        }
        if (user == null || EmptyUtil.isEmpty(user.getUsername()) || EmptyUtil.isEmpty(user.getPassword())) {
            return Result.failed("参数错误，请检查接口参数");
        }
        //密码加密
        String encryptPwd = securityService.pwdEncrypt(user.getPassword());
        user.setPassword(encryptPwd);

        List<UserEntity> userEntitys = userService.list(user);
        if (userEntitys == null || userEntitys.size() != 1) {
            return Result.failed("请检查用户名密码");
        }
        user = userEntitys.get(0);


        User loginUser = userService.doGetUser(user);
        loginUser.setSubsystemEntity(loginSubsystem);
        LogUtil.DebugLog(this, "当前登录的系统是" + loginSubsystem.getId());
        boolean canLogin = securityService.hasAuthor(loginUser, loginSubsystem.getId());
        if (!canLogin) {
            return Result.failed("用户无此系统权限");
        }

        String token = JwtTokenGenerator.generateToken(loginUser, Constant.JWTSECRET);
        LogUtil.DebugLog(this, "token is" + token);
        loginUser.setToken(token);
        loginUser.setLastLoginDate(new Date());
        loginUser.setLoginCount(loginUser.getLoginCount() + 1);
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httprequest = sra.getRequest();
        loginUser.setIpAddr(LogUtil.getIpAddr(httprequest));

        userService.update(loginUser);

        String secret = EncrUtil.GetMD5Code(token);
        loginUser.setSecret(secret);
        redisUtils.set(loginUser.getId() + Constant.encryptKey, token, Constant.LOGIN_EXPIRETIME);
        redisUtils.set(secret + Constant.encryptKey, loginUser, Constant.LOGIN_EXPIRETIME);
        if (!AppCache.loginTree.contains(loginUser)) {
            AppCache.loginTree.add(loginUser);
        }
        LogUtil.DebugLog(this, "当前登录人数为：" + AppCache.loginTree.size());
        return Result.successed(loginUser, "登录成功");
    }

    @Override
    public Result doGetSMSCode(Request<String> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result getAuths(Request<User> request) {
        User loginUser = request.getData();
        String secret = loginUser.getSecret();
        if (EmptyUtil.isEmpty(secret)) {
            return Result.failed("secret 不能为空");
        }
        User authorsUser = (User) redisUtils.get(secret + Constant.encryptKey);
        if (authorsUser == null) {
            return Result.failed("获取用户权限失败");
        }
        return Result.successed(authorsUser);
    }

}
