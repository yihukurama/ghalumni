package ${package};

import ${entityPackage}.${entityName};
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * 说明： ${entityName}的通用mapper接口
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@Repository
public interface ${domainName}Mapper extends Mapper<${entityName}> {
}

