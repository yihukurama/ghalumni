package com.ghds.alumni.app.cache;

import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description: 系统缓存
 * @Author: dengshuai
 * @Date: Created in 14:47 2018/1/17
 * @Modified: by autor in 14:47 2018/1/17
 */
public class AppCache {


    /**
     * 在线用户
     */
    public static Set<UserEntity> loginTree = new CopyOnWriteArraySet<>();
}
