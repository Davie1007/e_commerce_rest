package com.karanjadavid.e_commerce_rest.customer.service;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.customer.repository.CustomerRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserRegistrationForm;
import com.karanjadavid.e_commerce_rest.systemuser.service.SystemUserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEditService extends BaseJpaRepoEditService<Customer, CustomerRepository> {

    private SystemUserEditService systemUserEditService;

    @Autowired
    public void setSystemUserEditService(SystemUserEditService service){
        this.systemUserEditService = service;
    }

}
