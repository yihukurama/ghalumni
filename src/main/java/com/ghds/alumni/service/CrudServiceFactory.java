package com.ghds.alumni.service;

import com.ghds.alumni.app.component.SpringBeanTools;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.service.domainservice.CrudService;
import org.springframework.stereotype.Component;

/**
 * 说明： 基础增删改查
 *
 * @author: dengshuai
 * @date: Created in 17:54 2018/4/9
 * @modified: by autor in 17:54 2018/4/9
 */
@Component
public class CrudServiceFactory {


    public final static String ENTITY_STRING = "Entity";

    /**
     * 说明： 传入Entity的类名，得到对应的service
     *
     * @param domainName xxEntity
     * @return service
     * @throws ClassNotFoundException
     * @author: dengshuai
     * @date: Created in 11:33 2018/4/2
     * @modified: by autor in 11:33 2018/4/2
     */
    public CrudService createService(String domainName) throws TipsException {

        if (domainName.endsWith(ENTITY_STRING)) {
            domainName = domainName.replace("Entity", "");
        }
        String mapperName = domainName + "Service";
        LogUtil.DebugLog(this, "想要获取的Service是:" + Constant.packageAdminDomainService + mapperName);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(Constant.packageAdminDomainService + mapperName);
            CrudService crudService = (CrudService) SpringBeanTools.getBean(clazz);
            return crudService;
        } catch (ClassNotFoundException e) {

        }
        try {
            clazz = Class.forName(Constant.packageBusinessDomainService + mapperName);
            CrudService crudService = (CrudService) SpringBeanTools.getBean(clazz);
            return crudService;
        } catch (ClassNotFoundException e) {

        }
        throw new TipsException("无法获得有效的service");
    }
}
