package com.ghds.alumni.service.domainservice.admin;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.Empservbranch;
import com.ghds.alumni.domain.admin.Roleprivilege;
import com.ghds.alumni.domain.tkmapper.entity.admin.EmpservbranchEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.RoleprivilegeEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.EmpservbranchMapper;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明： 员工网点关联领域服务
 * @author dengshuai
 * @date Created in 11:24 2018/5/4
 * @modified by autor in 11:24 2018/5/4
 */
@Service
public class EmpservbranchService extends CrudService<Empservbranch> {

    @Autowired
    EmpservbranchMapper empservbranchMapper;

    @Override
    public Empservbranch create(Empservbranch empservbranch) throws TipsException {
        LogUtil.DebugLog(this,"获取的数据是"+ JSON.toJSONString(empservbranch));
        List<String> serviceBranchIds = empservbranch.getServiceBranchIds();
        if(EmptyUtil.isEmpty(empservbranch.getEmployeeId()) || EmptyUtil.isEmpty(empservbranch.getServiceBranchIds())){
            throw new TipsException("创建员工网点关联时员工Id和网点Id都不能为空");
        }


        LogUtil.InfoLog(this,"删除原来该员工的配置网点");
        EmpservbranchEntity empservbranchEntity = new EmpservbranchEntity();
        empservbranchEntity.setEmployeeId(empservbranch.getEmployeeId());
        empservbranchMapper.delete(empservbranchEntity);

        LogUtil.InfoLog(this,"开始插入员工网点配置...");
        for (String serviceBranchId:serviceBranchIds
                ) {
            EmpservbranchEntity insertEmpservbranch = new EmpservbranchEntity();
            insertEmpservbranch.setServiceBranchId(serviceBranchId);
            insertEmpservbranch.setEmployeeId(empservbranch.getEmployeeId());
            empservbranchMapper.insertSelective(insertEmpservbranch);
            empservbranch.setId(insertEmpservbranch.getId());
        }


        LogUtil.InfoLog(this,"插入权限完毕...");

        return empservbranch;
    }
}
