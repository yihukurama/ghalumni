package com.ghds.alumni.domain.tkmapper.mapper.business;

import com.ghds.alumni.domain.business.Wxuser;
import com.ghds.alumni.domain.tkmapper.entity.admin.RoleEntity;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.entity.business.WxuserEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 说明： WxuserEntity的通用mapper接口
 * @author: dengshuai
 * @date: Created in 15:18 2018/4/4
 * @modified: by autor in 15:18 2018/4/4
 */
@Repository
public interface WxuserMapper extends Mapper<WxuserEntity> {

    List<WxuserEntity> selectByTagText(Wxuser wxuser);
}

