package com.ghds.alumni.service.domainservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.domain.tkmapper.entity.admin.FuncEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.SubsystemEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.SubsystemMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： func的领域服务
 * @author dengshuai
 * @date Created in 15:52 2018/4/18
 * @modified by autor in 15:52 2018/4/18
 */
@Service
public class FuncService extends CrudService<FuncEntity> {

    @Autowired
    SubsystemMapper subsystemMapper;
    @Override
    public FuncEntity create(FuncEntity funcEntity) throws TipsException {
        if(!EmptyUtil.isEmpty(funcEntity.getSubSystemId())){
            SubsystemEntity subsystemEntity = subsystemMapper.selectByPrimaryKey(funcEntity.getSubSystemId());
            funcEntity.setSubSystemName(subsystemEntity.getText());
        }
        return super.create(funcEntity);
    }
}
