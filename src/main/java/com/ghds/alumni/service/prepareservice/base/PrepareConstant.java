package com.ghds.alumni.service.prepareservice.base;

public class PrepareConstant {
    public static final String PROJECT = "ystadmin";
    public final static String DBCOLUMN_CREATEDATE = "createDate";
    public final static String DBCOLUMN_INDEXORDER = "indexOrder";
    public final static String DBCOLUMN_DELSTATUS = "delStatus";
    public final static String DBCOLUMN_PARENTID = "parentId";

    public static final String ENTITYTPL_PATH = "src\\main\\java\\com\\ghds\\alumni\\service\\prepareservice\\base\\tpl\\entity/BaseEntity.tpl";
    public static final String MAPPERTPL_PATH = "src\\main\\java\\com\\ghds\\alumni\\service\\prepareservice\\base\\tpl\\mapper/Mapper.tpl";
    public static final String DOMAINSERVICETPL_PATH = "src\\main\\java\\com\\ghds\\alumni\\service\\prepareservice\\base\\tpl\\service\\Service.tpl";

    public static String adminEntityPackage = "com.ghds.alumni.domain.tkmapper.entity.admin";
    public static String businessEntityPackage = "com.ghds.alumni.domain.tkmapper.entity.business";

    public static String adminMapperPackage = "com.ghds.alumni.domain.tkmapper.mapper.admin";
    public static String businessMapperPackage = "com.ghds.alumni.domain.tkmapper.mapper.business";

    public static String adminDomainServicePackage = "com.ghds.alumni.service.domainservice.admin";
    public static String businessDomainServicePackage = "com.ghds.alumni.service.domainservice.business";

    public static String adminEntityPath = "src\\main\\java\\com\\ghds\\alumni\\domain\\tkmapper\\entity\\admin";
    public static String businessEntityPath = "src\\main\\java\\com\\ghds\\alumni\\domain\\tkmapper\\entity\\business";

    public static String adminMapperPath = "src\\main\\java\\com\\ghds\\alumni\\domain\\tkmapper\\mapper\\admin";
    public static String businessMapperPath = "src\\main\\java\\com\\ghds\\alumni\\domain\\tkmapper\\mapper\\business";

    public static String adminDomainServicePath = "src\\main\\java\\com\\ghds\\alumni\\service\\domainservice\\admin";
    public static String businessDomainServicePath = "src\\main\\java\\com\\ghds\\alumni\\service\\domainservice\\business";


}
