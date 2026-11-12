package com.karanjadavid.e_commerce_rest.customer.service;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.customer.repository.CustomerRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserRegistrationForm;
import com.karanjadavid.e_commerce_rest.systemuser.service.CommonSystemUserFieldsMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerEditService extends BaseJpaRepoEditService<Customer, CustomerRepository> {

    private CommonSystemUserFieldsMapper mapper = new CommonSystemUserFieldsMapper();

    public Customer registerCustomer(SystemUserRegistrationForm form){
        var customer = new Customer();
        mapper.mapCommonSystemUserFields(customer, form);
        return customer;
    }

    public Customer editCustomer(String customerId, SystemUserEditForm form){
        var customer = findByEntityId(customerId);
        mapper.mapCommonSystemUserFields(customer, form);
        return customer;
    }

}
