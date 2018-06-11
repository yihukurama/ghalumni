package com.ghds.alumni.web.admin;

import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.web.CommController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AdminBaseController")
public class AdminBaseController extends CommController {

    public AdminBaseController() {
        super();
        packageD = Constant.packageAdminDomain;
    }


}
