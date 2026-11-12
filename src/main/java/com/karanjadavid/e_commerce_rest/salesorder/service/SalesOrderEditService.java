package com.karanjadavid.e_commerce_rest.salesorder.service;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;
import com.karanjadavid.e_commerce_rest.salesorder.form.SalesOrderEditForm;
import com.karanjadavid.e_commerce_rest.salesorder.form.SalesOrderRegistrationForm;
import com.karanjadavid.e_commerce_rest.salesorder.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderEditService extends BaseJpaRepoEditService<SalesOrder, SalesOrderRepository> {

    private CustomerReadService customerReadService;

    public SalesOrder registerSalesOrder(SalesOrderRegistrationForm form){
        var salesOrder = new SalesOrder();
        mapFields(salesOrder, form);
        salesOrder = save(salesOrder, form.getSessionUserId());
        return salesOrder;
    }

    public SalesOrder editSalesOrder(String orderId, SalesOrderEditForm form){
        var salesOrder = findByEntityId(orderId);
        mapFields(salesOrder, form);
        salesOrder = save(salesOrder, form.getSessionUserId());
        return salesOrder;
    }

    private void mapFields(SalesOrder salesOrder, SalesOrderEditForm form){
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());
        salesOrder.setCustomer(customer);
    }

    @Autowired
    public void setCustomerReadService(CustomerReadService service){
        this.customerReadService = service;
    }

}
