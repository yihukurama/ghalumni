package com.ghds.alumni.service.domainservice;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.component.annotation.SqlCriteriaFactory;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.constant.MagicCode;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.app.utils.EmptyUtil;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.tkmapper.MapperFactory;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.web.dto.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * 说明： 领域服务的基础增删查改
 *
 * @author: dengshuai
 * @date: Created in 11:37 2018/4/2
 * @modified: by autor in 11:37 2018/4/2
 */
public class CrudService<T extends BaseEntity> {

    @Autowired
    MapperFactory mapperFactory;

    @Autowired
    SqlCriteriaFactory sqlCriteriaFactory;

    @Autowired
    UserMapper userMapper;

    /**
     * 说明： 依据条件加载一条数据
     *
     * @author dengshuai
     * @date Created in 15:29 2018/4/10
     * @modified by autor in 15:29 2018/4/10
     */
    public T create(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());

        String createrId = (String) getValueByField(t, "createrId");
        if(!EmptyUtil.isEmpty(createrId)){
            UserEntity userEntity = new UserEntity();
            userEntity.setId(createrId);
            userEntity = userMapper.selectByPrimaryKey(userEntity);
            changeValueByFieldIfNull(t, "creater", userEntity.getEmployeeName(), String.class);
        }

        int row = mapper.insertSelective(t);
        if (row == 1) {
            return mapper.selectByPrimaryKey(t);
        }
        return null;
    }

    /**
     * 说明： 根据条件增加一批数据
     * @author: ouyaokun
     * @date: Created in 14:46 2018/5/2
     * @modified: by autor in 14:46 2018/5/2
     * @param
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int creates(List<T> list) throws TipsException {
        Integer sum = 0;
        for(T t : list) {
            Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());

            String createrId = (String) getValueByField(t, "createrId");
            if(!EmptyUtil.isEmpty(createrId)){
                UserEntity userEntity = new UserEntity();
                userEntity.setId(createrId);
                userEntity = userMapper.selectByPrimaryKey(userEntity);
                changeValueByFieldIfNull(t, "creater", userEntity.getEmployeeName(), String.class);
            }

            int row = mapper.insertSelective(t);
            if (row == 1) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 说明： 依据条件加载一条数据
     *
     * @author dengshuai
     * @date Created in 15:29 2018/4/10
     * @modified by autor in 15:29 2018/4/10
     */
    public T loadOneByCondition(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        changeDelStatusIfNull(t);
        return mapper.selectOne(t);
    }

    /**
     * 说明： 加载单条数据
     *
     * @author: dengshuai
     * @date: Created in 11:38 2018/4/2
     * @modified: by autor in 11:38 2018/4/2
     */
    public T load(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        return mapper.selectByPrimaryKey(t);
    }

    /**
     * 说明： 根据主键进行更新
     *
     * @author: dengshuai
     * @date: Created in 15:43 2018/4/9
     * @modified: by autor in 15:43 2018/4/9
     */
    public T update(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());

        String operatorId = (String) getValueByField(t, "operatorId");
        if(!EmptyUtil.isEmpty(operatorId)){
            UserEntity userEntity = new UserEntity();
            userEntity.setId(operatorId);
            userEntity = userMapper.selectByPrimaryKey(userEntity);
            changeValueByFieldIfNull(t, "operator", userEntity.getEmployeeName(), String.class);
        }

        changeValueByFieldIfNull(t, "operateDate", new Date(), Date.class);

        int updateRow = mapper.updateByPrimaryKeySelective(t);
        if (updateRow == 1) {
            t = mapper.selectByPrimaryKey(t);
            return t;
        }

        return null;
    }

    private Object getValueByField(T t, String field){
        if(EmptyUtil.isEmpty(field)){
            return null;
        }

        String fieldFragments = field.substring(0, 1).toUpperCase() + field.substring(1);

        Method getMethod = null;
        try {
            getMethod = t.getClass().getMethod("get" + fieldFragments);
        }catch (NoSuchMethodException e){

        }

        if(getMethod == null){
            return null;
        }

        try {
            return getMethod.invoke(t);
        }catch (Exception e){
            LogUtil.ErrorLog(this, e.getMessage());
        }

        return null;
    }

    private void changeValueByFieldIfNull(T t, String field, Object defaultValue, Class type){
        if(EmptyUtil.isEmpty(field)){
            return;
        }

        String fieldFragments = field.substring(0, 1).toUpperCase() + field.substring(1);

        Method setMethod = null;
        try{
            setMethod = t.getClass().getMethod("set" + fieldFragments, type);
        }catch (NoSuchMethodException e) {

        }
        if(setMethod == null) {
            return;
        }

        Method getMethod = null;
        try {
            getMethod = t.getClass().getMethod("get" + fieldFragments);
        }catch (NoSuchMethodException e){

        }
        try {
            if(getMethod != null && getMethod.invoke(t) != null){
                return;
            }


            setMethod.invoke(t, defaultValue);
        }catch (Exception e){
            LogUtil.ErrorLog(this, e.getMessage());
        }

    }

    /**
     * 说明： 加载列表数据不分页
     *
     * @author: dengshuai
     * @date: Created in 11:38 2018/4/2
     * @modified: by autor in 11:38 2018/4/2
     */
    public List<T> list(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        changeDelStatusIfNull(t);
        List<T> tList = mapper.select(t);
        return tList;
    }

    private void changeDelStatusIfNull(Object t){
        Method setMethod = null;
        try{
            setMethod = t.getClass().getMethod(MagicCode.SETDELSTATUS, Integer.class);
        }catch (NoSuchMethodException e) {

        }
        if(setMethod == null) {
            return;
        }

        Method getMethod = null;
        try {
            getMethod = t.getClass().getMethod(MagicCode.GETDELSTATUS);
        }catch (NoSuchMethodException e){

        }

        try {
            if (getMethod != null && getMethod.invoke(t) != null) {
                return;
            }


            setMethod.invoke(t, 0);
        }catch (Exception e){
            LogUtil.ErrorLog(this, e.getMessage());
        }
    }

    /**
     * 说明： 加载列表数据前端调用分页
     *
     * @author: dengshuai
     * @date: Created in 11:38 2018/4/2
     * @modified: by autor in 11:38 2018/4/2
     */
    public Result list(T t, Integer page, Integer limit) throws TipsException, NoSuchMethodException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        List<T> tList = null;
        Result result = null;

        LogUtil.DebugLog(this, "查询条件是：" + JSON.toJSONString(t));
        //给查询赋值
        Condition condition = new Condition(t.getClass().getSuperclass());
        Example.Criteria criteria = condition.createCriteria();
        criteria = sqlCriteriaFactory.GeneraCriteria(criteria,t);

        //排序
        boolean hasDelStatus = false;
        Method[] methods = t.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.equals(MagicCode.SETDELSTATUS)){
                hasDelStatus = true;
                continue;
            }
            if (methodName.equals(MagicCode.SETINDEXORDER)) {
                condition.setOrderByClause(MagicCode.INDEXORDER + " DESC");
                continue;
            }
            if (methodName.equals(MagicCode.SETCREATEDATE) && EmptyUtil.isEmpty(condition.getOrderByClause())) {
                condition.setOrderByClause(MagicCode.CREATEDATE + " DESC");
                continue;
            }
        }
        if(hasDelStatus){
            t.getClass().getMethod(MagicCode.SETDELSTATUS, Integer.class);
            criteria.andEqualTo(Constant.DEL_STATUS, Constant.DEL_STATUS_0);
        }

        if (page != null && limit != null) {
            PageHelper.offsetPage(page, limit);
            tList = mapper.selectByExample(condition);
            PageInfo<T> pageInfo = new PageInfo<T>(tList);
            result = Result.successed(tList);
            result.setTotal(pageInfo.getTotal());

        } else {
            tList = mapper.selectByExample(condition);
            result = Result.successed(tList);

        }
        return result;
    }

    ;

    /**
     * 说明： 根据主键删除单条数据
     *
     * @author dengshuai
     * @date Created in 15:31 2018/4/10
     * @modified by autor in 15:31 2018/4/10
     */
    public int remove(T t) throws TipsException {
        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        int row = 0;
        Method method = null;

        try {
            method = t.getClass().getMethod(MagicCode.SETDELSTATUS, Integer.class);
        } catch (NoSuchMethodException | SecurityException e) {
            row = mapper.deleteByPrimaryKey(t);
            return row;
        }


        try {
            method.invoke(t, Constant.DEL_STATUS_1);
            Object o = mapper.updateByPrimaryKeySelective(t);
            if (o != null) {
                row = 1;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            row = 0;
            e.printStackTrace();
        }

        return row;
    }

    /**
     * 说明： 根据主键批量删除多条数据
     *
     * @author dengshuai
     * @date Created in 15:31 2018/4/10
     * @modified by autor in 15:31 2018/4/10
     */
    @Transactional(rollbackFor = Exception.class)
    public int removes(T t) throws TipsException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Mapper<T> mapper = mapperFactory.createMapper(t.getClass().getSimpleName());
        int row = 0;
        List<String> ids = t.getIds();

        boolean hasDelStatus = false;
        Method[] methods = t.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.equals(MagicCode.SETDELSTATUS)) {
                hasDelStatus = true;
                break;
            }
        }

        if (hasDelStatus) {
            Method method = t.getClass().getMethod(MagicCode.SETDELSTATUS, Integer.class);
            method.invoke(t, Constant.DEL_STATUS_1);
            for (String id : ids) {
                t.setId(id);
                Object o = mapper.updateByPrimaryKeySelective(t);
                if (o != null) {
                    row++;
                }
            }
        } else {
            for (String id : ids) {
                t.setId(id);
                int deleteRow = mapper.deleteByPrimaryKey(t);
                row += deleteRow;
            }
        }

        return row;
    }

}
