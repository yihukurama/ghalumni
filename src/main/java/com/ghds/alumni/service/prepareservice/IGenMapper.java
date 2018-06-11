package com.ghds.alumni.service.prepareservice;

import com.ghds.alumni.service.prepareservice.base.Table;

public interface IGenMapper {

    public int genMapper(Table table);

    public int genBaseMapper(Table table);

    public int genTreeMapper(Table table);

    public String genDBColumns(Table table);

    public String genInsertColumns(Table table);

    public String genBatchInsertColumns(Table table);

    public String genUpdateColumns(Table table);

    public String genListColumns(Table table);

    public String genOrderColumn(Table table);

}
