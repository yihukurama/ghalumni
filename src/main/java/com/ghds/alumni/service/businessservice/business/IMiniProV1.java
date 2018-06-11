package com.ghds.alumni.service.businessservice.business;

import com.ghds.alumni.web.business.dto.UpdatePersonalInfoDto;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;

/**
 * 说明：
 * @author dengshuai
 * @date Created in 14:13 2018/5/30
 * @modified by autor in 14:13 2018/5/30
 */
public interface IMiniProV1 {

    /**
     * 说明：更新个人信息
     * @author dengshuai
     * @date Created in 14:15 2018/5/30
     * @modified by autor in 14:15 2018/5/30
     */
    Result updatePersonalInfo(Request<UpdatePersonalInfoDto> request);
}
