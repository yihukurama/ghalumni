package com.ghds.alumni.service.domainservice.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.SubsystemEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.SubsystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ghds.alumni.service.domainservice.CrudService;
/**
 * 说明： Subsystem的领域服务
 * @author: dengshuai
 * @date: Created in 11:37 2018/4/2
 * @modified: by autor in 11:37 2018/4/2
 */
@Service
public class SubsystemService extends CrudService{
    @Autowired
    SubsystemMapper subsystemMapper;

    /**
     * 说明： 根据条件获取单个
     *
     * @author: dengshuai
     * @date: Created in 18:02 2018/4/9
     * @modified: by autor in 18:02 2018/4/9
     */
    public SubsystemEntity loadOneByCondition(SubsystemEntity subsystemEntity) {
        return subsystemMapper.selectOne(subsystemEntity);
    }


}
