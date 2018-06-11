package com.ghds.alumni.service.businessservice.admin;


import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;

public interface ISecurity {

    public String pwdEncrypt(String pwd);

    public String tokenEncrypt(String token);

    public String tokenDecrypt(String encryptToken);


    /**
     * @param loginUser 用户类，必须有用户id
     * @param id        权限id，系统，菜单，功能 id
     * @return 有权限返回真，无权限返回假
     * @Description: 用户鉴权
     * @Author: dengshuai
     * @Date: Created in 17:12 2018/1/3
     * @Modified: by author in 17:12 2018/1/3
     */
    public boolean hasAuthor(UserEntity loginUser, String id);
}
