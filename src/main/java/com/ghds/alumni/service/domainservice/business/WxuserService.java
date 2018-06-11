package com.ghds.alumni.service.domainservice.business;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.app.utils.YstUtils;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.domain.tkmapper.mapper.business.WxuserMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import com.ghds.alumni.service.domainservice.admin.EmployeeService;
import com.ghds.alumni.service.domainservice.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 说明： Wxuser的领域服务
 * @author: ouyaokun
 * @date: Created in 9:46 2018/5/8
 * @modified: by autor in 9:46 2018/5/8
 */
@Service
public class WxuserService extends CrudService<WxuserEntity> {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    WxuserMapper wxuserMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public WxuserEntity update(WxuserEntity wxuserEntity) throws TipsException {


        super.update(wxuserEntity);
        wxuserEntity = wxuserMapper.selectByPrimaryKey(wxuserEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(wxuserEntity.getUserId());
        userEntity.setStatus(wxuserEntity.getAuth()!=null&&wxuserEntity.getAuth()?User.STATE_1:User.STATE_0);
        LogUtil.DebugLog(this, "====================>1"+JSON.toJSONString(wxuserEntity));
        LogUtil.DebugLog(this, "====================>2"+JSON.toJSONString(userEntity));
        userMapper.updateByPrimaryKeySelective(userEntity);

        return wxuserEntity;
    }

    /**
     * 说明： 绑定微信用户到系统
     * @author: ouyaokun
     * @date: Created in 10:22 2018/5/8
     * @modified: by autor in 10:22 2018/5/8
     */
    @Transactional(rollbackFor = Exception.class)
    public WxuserEntity bindNewUser(WxuserEntity newWxuserEntity) throws TipsException {
        User user = new User();
        UserEntity userEntity = userService.createPerAccount(user);
        newWxuserEntity.setUserId(userEntity.getId());
        create(newWxuserEntity);


        return load(newWxuserEntity);
    }


}
