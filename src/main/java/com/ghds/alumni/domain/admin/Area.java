package com.ghds.alumni.domain.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.AreaEntity;

/**
 * 说明： area的领域对象
 *
 * @author: dengshuai
 * @date: Created in 15:01 2018/4/2
 * @modified: by autor in 15:01 2018/4/2
 */
public class Area extends AreaEntity {
    String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
