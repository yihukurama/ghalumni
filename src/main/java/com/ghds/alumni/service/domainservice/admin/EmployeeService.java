package com.ghds.alumni.service.domainservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.domain.admin.Employee;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： 员工领域对象
 * @author dengshuai
 * @date Created in 16:07 2018/4/20
 * @modified by autor in 16:07 2018/4/20
 */
@Service
public class EmployeeService extends CrudService<EmployeeEntity> {


    @Override
    public EmployeeEntity update(EmployeeEntity employee) throws TipsException {
        if (employee != null && EmptyUtil.isEmpty(employee.getId())){
            return super.create(employee);
        }

        return super.update(employee);
    }
}