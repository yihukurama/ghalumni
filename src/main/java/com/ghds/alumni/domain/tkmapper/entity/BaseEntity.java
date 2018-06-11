package com.ghds.alumni.domain.tkmapper.entity;

import com.ghds.alumni.app.component.annotation.SqlWhere;
import com.ghds.alumni.app.constant.MagicCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

public class BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 批量id处理字段
     */
    private List<String> ids;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.IN,proprtityName = MagicCode.ID)
    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
