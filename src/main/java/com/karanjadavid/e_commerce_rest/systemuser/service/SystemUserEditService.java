package com.karanjadavid.e_commerce_rest.systemuser.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserRegistrationForm;
import com.karanjadavid.e_commerce_rest.systemuser.repository.SystemUserRepository;
import org.springframework.stereotype.Service;

@Service
public class SystemUserEditService extends BaseJpaRepoEditService<SystemUser, SystemUserRepository> {

    public SystemUser registerSystemUser(SystemUserRegistrationForm form){
        var user = new SystemUser();
        mapFields(user, form);
        return user;
    }

    public SystemUser editSystemUser(String userId, SystemUserEditForm form){
        var user = findByEntityId(userId);
        mapFields(user, form);
        return user;
    }

    private void mapFields(SystemUser user, SystemUserEditForm form){
        user.setName(form.getName());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
    }

}
