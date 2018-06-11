package com.ghds.alumni.web.admin;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company/api")
@Api(value = "/company/api", description = "公司组织管理接口")
public class CompanyManageController {

}
