package com.ghds.alumni.web;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.tkmapper.entity.BaseEntity;
import com.ghds.alumni.service.CrudServiceFactory;
import com.ghds.alumni.service.domainservice.CrudService;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class CommController {


    @Autowired
    CrudServiceFactory crudServiceFactory;

    protected String packageD = "";

    @RequestMapping(value = "/{domain}/create", method = RequestMethod.POST)
    public Result create(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此create接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        Object o = crudService.create(tt);
        if (o == null) {
            return Result.failed("创建失败");
        }

        return Result.successed(o);
    }

    @RequestMapping(value = "/{domain}/update", method = RequestMethod.POST)
    public Result update(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此update接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        Object o = crudService.update(tt);
        if (o == null) {
            return Result.failed("创建失败");
        }

        return Result.successed(o);
    }

    @RequestMapping(value = "/{domain}/load", method = RequestMethod.POST)
    public Result load(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此load接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        Object o = crudService.load(tt);


        return Result.successed(o);
    }

    @RequestMapping(value = "/{domain}/loadOneByCondition", method = RequestMethod.POST)
    public Result loadOneByCondition(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此load接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        Object o = crudService.loadOneByCondition(tt);


        return Result.successed(o);
    }


    @RequestMapping(value = "/{domain}/list", method = RequestMethod.POST)
    public Result list(@RequestBody Request request, @PathVariable String domain) throws TipsException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此list接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);


        return crudService.list(tt, request.getPage(), request.getLimit());
    }

    @RequestMapping(value = "/{domain}/remove", method = RequestMethod.POST)
    public Result remove(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此remove接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        int row = crudService.remove(tt);
        if (row == 1) {
            return Result.successed(row);
        }

        return Result.failed("删除单条数据失败");
    }


    @RequestMapping(value = "/{domain}/removs", method = RequestMethod.POST)
    public Result removes(@RequestBody Request request, @PathVariable String domain) throws TipsException {


        String classPackage = packageD + domain;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPackage);
        } catch (ClassNotFoundException e) {
            return Result.failed("无此removes接口");
        }
        String json = JSON.toJSONString(request.getData());
        BaseEntity tt = JSON.parseObject(json, (Type) clazz);

        CrudService crudService = crudServiceFactory.createService(domain);
        int row = 0;
        try {
            row = crudService.removes(tt);
        } catch (NoSuchMethodException e) {
            return Result.failed("删除多条数据失败:" + e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            return Result.failed("删除多条数据失败:" + e.getMessage());
        }
        if (row > 0) {
            return Result.successed(row);
        }

        return Result.failed("删除多条数据失败");
    }


}
