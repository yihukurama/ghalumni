package com.ghds.alumni.service.businessservice.admin.impl;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EncrUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.tkmapper.entity.admin.RoleprivilegeEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.service.businessservice.admin.ISecurity;
import com.ghds.alumni.service.domainservice.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SecurityService implements ISecurity {

    @Autowired
    UserService userService;

    @Override
    public String pwdEncrypt(String pwd) {
        //避免撞库
        pwd = pwd + Constant.encryptKey;
        pwd = EncrUtil.GetMD5Code(pwd);

        return pwd;
    }

    @Override
    public String tokenEncrypt(String token) {
        String encryptFirst = EncrUtil.AESEncrypt(token);
        String result = EncrUtil.AESEncrypt(encryptFirst);
        return result;
    }

    @Override
    public String tokenDecrypt(String encryptToken) {
        String encryptFirst = EncrUtil.AESDecrypt(encryptToken);
        String result = EncrUtil.AESDecrypt(encryptFirst);
        return result;
    }

    @Override
    public boolean hasAuthor(UserEntity userEntity, String previlegeId) {
        if (!userService.existUser(userEntity)) {
            LogUtil.DebugLog(this, "不存在此用户" + JSON.toJSONString(userEntity));
            return false;
        }
        if (userEntity.getUsername().equals("admin")) {
            LogUtil.DebugLog(this, "超级管理员拥有所有权限");
            return true;
        }
        User loginUser = null;
        try {
            loginUser = userService.doGetUser(userEntity);
        } catch (TipsException e) {
            e.printStackTrace();
            return false;
        }
        List<RoleprivilegeEntity> roleprivilegeEntities = loginUser.getPrivileges();
        for (RoleprivilegeEntity roleprivilege : roleprivilegeEntities
                ) {
            if (roleprivilege.getPrivilegeId().equals(previlegeId)) {
                return true;
            }
        }
        return false;
    }


}
