package com.karanjadavid.e_commerce_rest.customer.service;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.customer.repository.CustomerRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import org.springframework.stereotype.Service;

@Service
public class CustomerReadService extends BaseJpaRepoReadService<Customer, CustomerRepository> {
}
