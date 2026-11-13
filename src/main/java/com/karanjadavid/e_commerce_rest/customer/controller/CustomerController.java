package com.karanjadavid.e_commerce_rest.customer.controller;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerEditService;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserEditForm;
import com.karanjadavid.e_commerce_rest.systemuser.form.SystemUserRegistrationForm;
import com.karanjadavid.e_commerce_rest.systemuser.view.SystemUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerEditService customerEditService;

    @PostMapping("/register")
    public EntityApiResponse<SystemUserView> registerCustomer(@RequestBody SystemUserRegistrationForm form, Locale locale){
        var customer = customerEditService.registerCustomer(form);
        return new EntityApiResponse<>(
                Message.get("customer.registration.success", locale),
                new SystemUserView(customer)
        );
    }

    @PutMapping("/edit/{customerId}")
    public EntityApiResponse<SystemUserView> editCustomer(@PathVariable String customerId, @RequestBody SystemUserEditForm form, Locale locale){
        var customer = customerEditService.editCustomer(customerId, form);
        return new EntityApiResponse<>(
                Message.get("customer.edit.success", locale),
                new SystemUserView(customer)
        );
    }

    @Autowired
    public void setCustomerEditService(CustomerEditService service){
        this.customerEditService = service;
    }

}
