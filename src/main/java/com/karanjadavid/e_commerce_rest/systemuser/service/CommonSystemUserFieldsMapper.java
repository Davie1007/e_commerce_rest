package com.karanjadavid.e_commerce_rest.systemuser.service;

import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;

public class CommonSystemUserFieldsMapper {

    public void mapCommonSystemUserFields(SystemUser user, SystemUserEditForm form){
        user.setName(form.getName());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
    }

}
