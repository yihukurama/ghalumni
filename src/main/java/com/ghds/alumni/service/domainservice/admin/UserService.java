package com.ghds.alumni.service.domainservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.StringUtil;
import com.ghds.alumni.app.utils.YstUtils;
import com.ghds.alumni.domain.admin.Employee;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.tkmapper.entity.admin.*;
import com.ghds.alumni.domain.tkmapper.mapper.admin.DepartmentMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.EmployeeMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.OrganizationMapper;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明： User的领域服务
 * @author: dengshuai
 * @date: Created in 11:37 2018/4/2
 * @modified: by autor in 11:37 2018/4/2
 */
@Service
public class UserService extends CrudService<UserEntity> {
    @Autowired
    UserMapper userMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public UserEntity create(UserEntity userEntity) throws TipsException {
        if (!EmptyUtil.isEmpty(userEntity.getEmployeeId())){
            EmployeeEntity employeeEntity = employeeMapper.selectByPrimaryKey(userEntity.getEmployeeId());
            userEntity.setEmployeeName(employeeEntity.getRealName());
        }

        return super.create(userEntity);
    }

    /**
     * 说明： 获取用户信息，包括用户的角色，权限(系统，菜单，功能)，机构，部门，员工
     *
     * @author: dengshuai
     * @date: Created in 14:47 2018/4/9
     * @modified: by autor in 14:47 2018/4/9
     */
    public User doGetUser(UserEntity userEntity) throws TipsException {
        if (!existUser(userEntity)) {
            return null;
        }
        userEntity = this.load(userEntity);
        User user = YstUtils.transferEntity2Domain(userEntity, User.class);

        //获取用户相关信息
        List<RoleEntity> roleEntities = userMapper.selectRoleByUser(user);
        List<SubsystemEntity> subsystemEntities = userMapper.selectSubsystemByUser(user);
        List<MenuEntity> menuEntities = userMapper.selectMenuByUser(user);
        List<FuncEntity> funcEntities = userMapper.selectFuncByUser(user);
        EmployeeEntity employeeEntity = employeeMapper.selectByPrimaryKey(userEntity.getEmployeeId());
        if(employeeEntity!=null){
            DepartmentEntity departmentEntity = departmentMapper.selectByPrimaryKey(employeeEntity.getDepartmentId());
            OrganizationEntity organizationEntity = organizationMapper.selectByPrimaryKey(departmentEntity.getOrgId());
            user.setDepartment(departmentEntity);
            user.setEmp(employeeEntity);
            user.setOrg(organizationEntity);
            user.setRealName(employeeEntity.getRealName());
        }

        //设置用户相关信息

        user.setRoles(roleEntities);
        user.setSubSystemPrivileges(subsystemEntities);
        user.setMenuPrivileges(menuEntities);
        user.setFuncPrivileges(funcEntities);



        return user;

    }


    /**
     * 说明： 判断数据库中是否有此用户id
     *
     * @author: dengshuai
     * @date: Created in 14:17 2018/4/9
     * @modified: by autor in 14:17 2018/4/9
     */
    public Boolean existUser(UserEntity userEntity) {
        if (userEntity == null) {
            return Boolean.FALSE;
        }

        UserEntity loadUserEntity = null;

        try {
            loadUserEntity = this.load(userEntity);
        } catch (TipsException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }


        if (loadUserEntity == null) {
            return Boolean.FALSE;
        } else if (loadUserEntity != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    /**
     * 说明： 创建微信账号
     * @author: ouyaokun
     * @date: Created in 10:26 2018/5/8
     * @modified: by autor in 10:26 2018/5/8
     */
    public UserEntity createPerAccount(User user) throws TipsException {
        UserEntity newUser = new UserEntity();
        if(user.getUsername() == null){
            newUser.setUsername(StringUtil.getNum()); //默认用户名
        }
        newUser.setType(User.TYPE_5);
        newUser.setCreater("self");
        newUser.setStatus(User.STATE_1);
        newUser.setEmployeeName(user.getRealName());
        create(newUser);

        return load(newUser);
    }

}
