package com.ghds.alumni.service.businessservice.admin;

import org.springframework.ui.Model;

public interface IViewService {

    public Model initAdminIndex(Model model, String userId);

    public Model initAdminMenuIndex(Model model, String menuId);
}
