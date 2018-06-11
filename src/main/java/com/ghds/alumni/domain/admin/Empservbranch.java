package com.ghds.alumni.domain.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.EmpservbranchEntity;

import java.util.List;

/**
 * 说明： 员工网点关联领域对象
 * @author dengshuai
 * @date Created in 11:23 2018/5/4
 * @modified by autor in 11:23 2018/5/4
 */
public class Empservbranch extends EmpservbranchEntity {
    /**
     * 配置网点时提交的网点id
     */
    List<String> serviceBranchIds;

    public List<String> getServiceBranchIds() {
        return serviceBranchIds;
    }

    public void setServiceBranchIds(List<String> serviceBranchIds) {
        this.serviceBranchIds = serviceBranchIds;
    }
}
