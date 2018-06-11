package com.ghds.alumni.service.domainservice.admin;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.Roleprivilege;
import com.ghds.alumni.domain.tkmapper.entity.admin.RoleprivilegeEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.RoleprivilegeMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleprivilegeService extends CrudService<Roleprivilege> {

    @Autowired
    RoleprivilegeMapper roleprivilegeMapper;

    @Override
    public Roleprivilege create(Roleprivilege roleprivilege) throws TipsException {

        LogUtil.DebugLog(this,"获取的数据是"+ JSON.toJSONString(roleprivilege));
        List<String> menuIds = roleprivilege.getMenuIds();
        List<String> funcIds = roleprivilege.getFuncIds();
        if(EmptyUtil.isEmpty(roleprivilege.getRoleId()) || EmptyUtil.isEmpty(roleprivilege.getSubSystemId())){
            throw new TipsException("创建权限时角色Id和系统Id都不能为空");
        }
        LogUtil.DebugLog(this,"获得的menuIds是"+JSON.toJSONString(menuIds));

        LogUtil.InfoLog(this,"提交权限时先删除原来该系统的权限");
        RoleprivilegeEntity deleteRolePrivilege = new RoleprivilegeEntity();
        deleteRolePrivilege.setSubSystemId(roleprivilege.getSubSystemId());
        roleprivilegeMapper.delete(deleteRolePrivilege);

        LogUtil.InfoLog(this,"开始插入权限...");
        for (String menuId:menuIds
             ) {
            RoleprivilegeEntity roleprivilegeEntity = new RoleprivilegeEntity();
            roleprivilegeEntity.setPrivilegeId(menuId);
            roleprivilegeEntity.setType(Roleprivilege.TYPE_MENU);
            roleprivilegeEntity.setRoleId(roleprivilege.getRoleId());
            roleprivilegeEntity.setSubSystemId(roleprivilege.getSubSystemId());
            roleprivilegeMapper.insertSelective(roleprivilegeEntity);
            roleprivilege.setId(roleprivilegeEntity.getId());
        }

        for (String funcId:funcIds
                ) {
            RoleprivilegeEntity roleprivilegeEntity = new RoleprivilegeEntity();
            roleprivilegeEntity.setPrivilegeId(funcId);
            roleprivilegeEntity.setType(Roleprivilege.TYPE_FUNC);
            roleprivilegeEntity.setRoleId(roleprivilege.getRoleId());
            roleprivilegeEntity.setSubSystemId(roleprivilege.getSubSystemId());
            roleprivilegeMapper.insertSelective(roleprivilegeEntity);
            roleprivilege.setId(roleprivilegeEntity.getId());
        }
        LogUtil.InfoLog(this,"插入权限完毕...");

        return roleprivilege;
    }
}
