package com.ghds.alumni.app.config;

import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.tkmapper.entity.admin.ConfigurationEntity;
import com.ghds.alumni.service.domainservice.admin.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadSettings implements CommandLineRunner {

    @Autowired
    ConfigurationService configurationService;

    @Override
    public void run(String... args) {

        Constant.AUTHORID = new ArrayList<>();
        LogUtil.InfoLog(this, "加载系统配置。。。");
        List<ConfigurationEntity> configList = new ArrayList<>();
        try {
            configList = configurationService.list(new ConfigurationEntity());
        }catch (Throwable e){
            configList = new ArrayList<>();
            LogUtil.ErrorLog(this, e.getMessage());
        }

        for (ConfigurationEntity c : configList) {

            if (c.getCode().equals("SERVER_LOGIN_EXPIRETIME")) {
                Constant.LOGIN_EXPIRETIME = Long.parseLong(c.getValue());
                LogUtil.InfoLog(this, c.getNote() + "=" + Constant.LOGIN_EXPIRETIME);
            }
            if (c.getCode().equals("AUTHORID")) {
                Constant.AUTHORID.add(c.getValue());
                LogUtil.InfoLog(this, c.getNote() + "=" + c.getValue());
            }
        }


    }

}
