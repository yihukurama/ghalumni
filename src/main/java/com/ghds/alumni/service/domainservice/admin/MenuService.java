package com.ghds.alumni.service.domainservice.admin;

import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.domain.admin.Subsystem;
import com.ghds.alumni.domain.tkmapper.entity.admin.MenuEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.SubsystemEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.SubsystemMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： 菜单的领域服务
 * @author dengshuai
 * @date Created in 11:57 2018/4/18
 * @modified by autor in 11:57 2018/4/18
 */
@Service
public class MenuService extends CrudService<MenuEntity> {

    @Autowired
    SubsystemMapper subsystemMapper;

    @Override
    public MenuEntity create(MenuEntity menuEntity) throws TipsException {
        if(!EmptyUtil.isEmpty(menuEntity.getSubSystemId())){
            SubsystemEntity subsystemEntity = subsystemMapper.selectByPrimaryKey(menuEntity.getSubSystemId());
            menuEntity.setSubSystemName(subsystemEntity.getText());
        }
        return super.create(menuEntity);
    }

    @Override
    public MenuEntity update(MenuEntity menuEntity) throws TipsException {
        if(!EmptyUtil.isEmpty(menuEntity.getSubSystemId())){
            SubsystemEntity subsystemEntity = subsystemMapper.selectByPrimaryKey(menuEntity.getSubSystemId());
            menuEntity.setSubSystemName(subsystemEntity.getText());
        }
        return super.update(menuEntity);
    }
}
