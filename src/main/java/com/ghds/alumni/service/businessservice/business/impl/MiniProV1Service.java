package com.ghds.alumni.service.businessservice.business.impl;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.business.Tags;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.DepartmentEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.OrganizationEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.TagsEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.DepartmentMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.EmployeeMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.OrganizationMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.domain.tkmapper.mapper.business.TagsMapper;
import com.ghds.alumni.domain.tkmapper.mapper.business.WxuserMapper;
import com.ghds.alumni.service.businessservice.business.IMiniProV1;
import com.ghds.alumni.service.domainservice.business.TagsService;
import com.ghds.alumni.service.domainservice.business.WxuserService;
import com.ghds.alumni.web.business.dto.UpdatePersonalInfoDto;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiniProV1Service implements IMiniProV1 {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    WxuserMapper wxuserMapper;
    @Autowired
    WxuserService wxuserService;
    @Autowired
    TagsMapper tagsMapper;

    @Override
    public Result updatePersonalInfo(Request<UpdatePersonalInfoDto> request) {


        int empCount = 0;
        int userCount = 0;
        UpdatePersonalInfoDto updatePersonalInfoDto = request.getData();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setMobile(updatePersonalInfoDto.getPhoneNum());
        employeeEntity.setOrgId(updatePersonalInfoDto.getOrgId());
        employeeEntity.setCode(updatePersonalInfoDto.getCode());
        employeeEntity.setDepartmentId(updatePersonalInfoDto.getDepartMentId());
        employeeEntity.setRealName(updatePersonalInfoDto.getRealName());
        employeeEntity.setWorkAge(updatePersonalInfoDto.getWorkAge());
        employeeEntity.setId(updatePersonalInfoDto.getEmpId());
        employeeEntity.setNote(updatePersonalInfoDto.getNote());

        DepartmentEntity departmentEntity = departmentMapper.selectByPrimaryKey(updatePersonalInfoDto.getDepartMentId());
        employeeEntity.setDepartmentName(departmentEntity.getText());
        OrganizationEntity organizationEntity = organizationMapper.selectByPrimaryKey(updatePersonalInfoDto.getOrgId());
        employeeEntity.setOrgName(organizationEntity.getText());
        if(updatePersonalInfoDto.getEmpId()!=null){
            empCount = employeeMapper.updateByPrimaryKeySelective(employeeEntity);
        }else{
            empCount = employeeMapper.insertSelective(employeeEntity);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(updatePersonalInfoDto.getUserId());
        userEntity.setEmployeeId(employeeEntity.getId());
        userEntity.setEmployeeName(employeeEntity.getRealName());
        userEntity.setOrgId(updatePersonalInfoDto.getOrgId());
        userEntity.setOrgName(organizationEntity.getText());

        userCount = userMapper.updateByPrimaryKeySelective(userEntity);

        //更新微信用户资料
        Wxuser wxuser = updatePersonalInfoDto.getWxuser();
        wxuser.setRealName(employeeEntity.getRealName());
        wxuser.setWorkAge(employeeEntity.getWorkAge());
        LogUtil.DebugLog(this,"============>"+"微信用户更新0"+ JSON.toJSONString(updatePersonalInfoDto));
        if(wxuser!=null){
            LogUtil.DebugLog(this,"============>"+"微信用户更新1");
            if(!EmptyUtil.isEmpty(wxuser.getId())){
                LogUtil.DebugLog(this,"============>"+"微信用户更新2");
                wxuserMapper.updateByPrimaryKeySelective(wxuser);
            }
        }

        if(empCount == 1 && userCount == 1){
            return Result.successed(employeeEntity);
        }




        return Result.failed("更新个人信息失败");
    }

    @Override
    public Result searchInfos(Request<Wxuser> request) throws NoSuchMethodException, TipsException {

        /**
         * 得到用户信息
         */
        UserEntity userEntity = new UserEntity();
        userEntity.setId(request.getUid());
        userEntity = userMapper.selectByPrimaryKey(userEntity);
        if(userEntity == null){
            return Result.failed("无此用户");
        }

        /**
         * 得到微信信息
         */
        WxuserEntity wxuserEntity = new WxuserEntity();
        wxuserEntity.setUserId(request.getUid());
        wxuserEntity = wxuserMapper.selectOne(wxuserEntity);
        if(wxuserEntity == null){
            return Result.failed("无此微信用户");
        }

        /**
         * 得到员工信息
         */
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(userEntity.getEmployeeId());
        employeeEntity = employeeMapper.selectByPrimaryKey(employeeEntity);
        if(employeeEntity == null){
            return Result.failed("未完善个人信息,请完善个人信息再查询校友信息");
        }

        Wxuser searchWxuser = request.getData();
        if(searchWxuser == null){
            searchWxuser = new Wxuser();
        }

        return wxuserService.list(searchWxuser,request.getPage(),request.getLimit());



    }


}
