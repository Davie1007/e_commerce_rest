package com.karanjadavid.e_commerce_rest.systemuser.view;

import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;

public class SystemUserView extends BaseView<SystemUser> {
    public SystemUserView(SystemUser entity) {
        super(entity);
    }

    public String getName(){ return entity.getName(); }
    public String getEmail(){ return entity.getEmail(); }
    public String getPhoneNumber(){ return entity.getPhoneNumber(); }
}