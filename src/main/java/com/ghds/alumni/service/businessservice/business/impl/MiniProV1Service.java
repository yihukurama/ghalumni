package com.ghds.alumni.service.businessservice.business.impl;

import com.ghds.alumni.domain.admin.Department;
import com.ghds.alumni.domain.tkmapper.entity.admin.DepartmentEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.OrganizationEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.DepartmentMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.EmployeeMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.OrganizationMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.service.businessservice.business.IMiniProV1;
import com.ghds.alumni.web.business.dto.UpdatePersonalInfoDto;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(empCount == 1 && userCount == 1){
            return Result.successed(employeeEntity);
        }
        return Result.failed("更新个人信息失败");
    }
}
