package com.karanjadavid.e_commerce_rest.systemuser.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserRegistrationForm;
import com.karanjadavid.e_commerce_rest.systemuser.repository.SystemUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemUserEditService extends BaseJpaRepoEditService<SystemUser, SystemUserRepository> {

    private final PasswordEncoder passwordEncoder;

    public SystemUserEditService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public SystemUser registerSystemUser(SystemUserRegistrationForm form){
        var user = new SystemUser();
        mapFields(user, form, true);
        return save(user);
    }

    public SystemUser editSystemUser(String entityId, SystemUserEditForm form){
        var user = findByEntityId(entityId);
        mapFields(user, form, false);
        return save(user);
    }

    private void mapFields(SystemUser user, SystemUserEditForm form, boolean isNew){
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
        if (isNew || (form.getPassword() != null && !form.getPassword().isBlank())) {
            user.setPassword(passwordEncoder.encode(form.getPassword()));
        }
    }
}
