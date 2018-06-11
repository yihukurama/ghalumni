package com.ghds.alumni.domain.tkmapper.mapper.admin;

import com.ghds.alumni.domain.tkmapper.entity.admin.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 说明： UserEntity的通用mapper接口
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@Repository
public interface UserMapper extends Mapper<UserEntity> {
    List<RoleEntity> selectRoleByUser(UserEntity user);

    List<SubsystemEntity> selectSubsystemByUser(UserEntity user);

    List<MenuEntity> selectMenuByUser(UserEntity user);

    List<FuncEntity> selectFuncByUser(UserEntity user);

}

