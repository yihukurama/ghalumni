package com.ghds.alumni.app.component.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghds.alumni.app.constant.MagicCode;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Method;
import java.security.Key;
import java.util.Set;
/**
 * 说明：动态根据注解生成sql
 * @author dengshuai
 * @date Created in 14:44 2018/4/16
 * @modified by autor in 14:44 2018/4/16
 */
@Component
public class SqlCriteriaFactory<T extends BaseEntity> {

    public Example.Criteria GeneraCriteria(Example.Criteria criteria,T t) throws NoSuchMethodException {

        //查询条件
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
        Set<String> keys = jsonObject.keySet();
        for (String key : keys
                ) {
            String value = jsonObject.getString(key);
            String firstChar = String.valueOf(key.charAt(0));
            String getMethodName = key.replaceFirst(firstChar, firstChar.toUpperCase());
            LogUtil.DebugLog(this, "get方法是=====>get" + getMethodName);
            Method getMethod = t.getClass().getMethod("get" + getMethodName);
            SqlWhere sqlWhere = getMethod.getAnnotation(SqlWhere.class);
            if (sqlWhere != null) {
                //该方法有sqllike注解，应该用like查询
                String sqlWhereValue = sqlWhere.value().getValue();
                if(sqlWhereValue.equals(SqlWhere.SqlWhereValue.LIKE.getValue())){
                    value = "%"+value+"%";
                }if(sqlWhereValue.equals(SqlWhere.SqlWhereValue.IN.getValue())){
                    key = sqlWhere.proprtityName();
                    value = value.replace("[","(");
                    value = value.replace("]",")");
                }else{
                    value = "'"+value+"'";
                }
                //针对createGT等范围查询需要得到对应的字段，如create
                LogUtil.DebugLog(this,"条件查询的注解名是"+sqlWhere.value().name());
                LogUtil.DebugLog(this,"条件查询的key名是"+ key);
                if(key.contains(sqlWhere.value().name())){
                    key = key.replace(sqlWhere.value().name(),"");
                }

                LogUtil.DebugLog(this,"最后条件查询的key名是"+ key);
                criteria.andCondition(key + sqlWhereValue+value);

                continue;
            }

            criteria.andEqualTo(key, value);
        }


        return criteria;
    }

}
