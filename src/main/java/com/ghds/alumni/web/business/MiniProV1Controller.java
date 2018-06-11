package com.ghds.alumni.web.business;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.domain.admin.Employee;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.service.businessservice.business.IMiniProV1;
import com.ghds.alumni.service.domainservice.admin.EmployeeService;
import com.ghds.alumni.web.business.dto.UpdatePersonalInfoDto;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明： 小程序一期业务接口
 * @author dengshuai
 * @date Created in 10:15 2018/5/30
 * @modified by autor in 10:15 2018/5/30
 */
@RestController
@RequestMapping("/MiniProV1Controller")
public class MiniProV1Controller {

    @Autowired
    IMiniProV1 miniProV1;
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(httpMethod = "POST", value = "更新个人资料", notes = "更新个人资料")
    @RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST)
    public Result updatePersonalInfo(@RequestBody Request<UpdatePersonalInfoDto> request) throws TipsException
    {

        return miniProV1.updatePersonalInfo(request);
    }

    @Autowired
    UserMapper userMapper;
    @ApiOperation(httpMethod = "POST", value = "更新个人资料", notes = "更新个人资料")
    @RequestMapping(value = "/listEmpInfos", method = RequestMethod.POST)
    public Result listEmpInfos(@RequestBody Request<Employee> request) throws TipsException, NoSuchMethodException {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(request.getUid());
        userEntity = userMapper.selectByPrimaryKey(userEntity);
        if(userEntity!=null && (userEntity.getStatus() == null || !userEntity.getStatus().equals(User.STATE_1))){
            return Result.failed("未认证校友不能查询校友信息，请等待认证");
        }

        return employeeService.list(request.getData(),request.getPage(),request.getLimit());
    }

}
