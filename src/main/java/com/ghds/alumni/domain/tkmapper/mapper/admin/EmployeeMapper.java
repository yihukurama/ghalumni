package com.ghds.alumni.domain.tkmapper.mapper.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.EmployeeEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * 说明： EmployeeEntity的通用mapper接口
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@Repository
public interface EmployeeMapper extends Mapper<EmployeeEntity> {
}

