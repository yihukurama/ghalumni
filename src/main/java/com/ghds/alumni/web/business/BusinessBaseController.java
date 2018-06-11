package com.ghds.alumni.web.business;

import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.web.CommController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BusinessBaseController")
public class BusinessBaseController extends CommController {

    public BusinessBaseController() {
        super();
        packageD = Constant.packageBusinessDomain;
    }

}
