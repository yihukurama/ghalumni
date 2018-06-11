package com.ghds.alumni.domain.tkmapper;

import com.ghds.alumni.app.component.SpringBeanTools;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.exception.TipsException;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public class MapperFactory {


    public final static String adminMapperPackage = "com.ds.test.tkmapperdemo.domain.tkmapper.mapper.admin.";
    public final static String businessMapperPackage = "com.ds.test.tkmapperdemo.domain.tkmapper.mapper.business.";
    public final static String ENTITY_STRING = "Entity";

    /**
     * 说明： 传入Entity的类名，得到对应的tkmapper
     *
     * @param domainName xxEntity
     * @return tkMapper
     * @throws ClassNotFoundException
     * @author: dengshuai
     * @date: Created in 11:33 2018/4/2
     * @modified: by autor in 11:33 2018/4/2
     */
    public Mapper createMapper(String domainName) throws TipsException {

        if (domainName.endsWith(ENTITY_STRING)) {
            domainName = domainName.replace("Entity", "");
        }
        String mapperName = domainName + "Mapper";
        Class<?> clazz = null;
        try {
            clazz = Class.forName(Constant.packageAdminMapper + mapperName);
            Mapper mapper = (Mapper) SpringBeanTools.getBean(clazz);

            return mapper;
        } catch (ClassNotFoundException e) {

        }
        try {
            clazz = Class.forName(Constant.packageBusinessMapper + mapperName);
            Mapper mapper = (Mapper) SpringBeanTools.getBean(clazz);

            return mapper;
        } catch (ClassNotFoundException e) {

        }

        throw new TipsException("无法获取有效的mapper");
    }


}
