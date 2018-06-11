package com.ghds.alumni.service.businessservice.business.impl;

import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.business.WxuserMapper;
import com.ghds.alumni.service.businessservice.business.IPublicBus;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： 公开业务实现类
 * @author dengshuai
 * @date Created in 9:57 2018/5/15
 * @modified by autor in 9:57 2018/5/15
 */
@Service
public class PubliceBusService implements IPublicBus {

    @Autowired
    WxuserMapper wxuserMapper;

    @Override
    public Result bindWxUser(Request<Wxuser> wxuserRequest) {

        Wxuser wxuserEntity = wxuserRequest.getData();

        WxuserEntity wxUser = new WxuserEntity();
        wxUser.setPerOpenId(wxuserEntity.getPerOpenId());
        WxuserEntity dbWxUser = null;
        try {
            dbWxUser = wxuserMapper.selectOne(wxUser);
        }catch (TooManyResultsException exception){

        }

        if(dbWxUser!=null){
            String wxuserId = dbWxUser.getId();
            wxuserEntity.setId(wxuserId);
            wxuserMapper.updateByPrimaryKeySelective(wxuserEntity);
            return Result.successed(wxuserEntity);
        }

        wxuserMapper.insertSelective(wxuserEntity);
        return Result.successed(wxuserEntity);
    }
}
