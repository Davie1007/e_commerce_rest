package com.karanjadavid.e_commerce_rest.salesorder.controller;

import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.salesorder.form.SalesOrderEditForm;
import com.karanjadavid.e_commerce_rest.salesorder.form.SalesOrderRegistrationForm;
import com.karanjadavid.e_commerce_rest.salesorder.service.SalesOrderEditService;
import com.karanjadavid.e_commerce_rest.salesorder.view.SalesOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/sales-order")
public class SalesOrderController {

    private SalesOrderEditService salesOrderEditService;

    @PostMapping("/register")
    public EntityApiResponse<SalesOrderView> registerSalesOrder(@RequestBody SalesOrderRegistrationForm form, Locale locale){
        var order = salesOrderEditService.registerSalesOrder(form);
        return new EntityApiResponse<>(
                Message.get("sales.order.registration.success", locale),
                new SalesOrderView(order)
        );
    }

    @PutMapping("/edit/{orderId}")
    public EntityApiResponse<SalesOrderView> editSalesOrder(@PathVariable String orderId, @RequestBody SalesOrderEditForm form, Locale locale){
        var order = salesOrderEditService.editSalesOrder(orderId, form);
        return new EntityApiResponse<>(
                Message.get("sales.order.edit.success", locale),
                new SalesOrderView(order)
        );
    }

    @Autowired
    public void setSalesOrderEditService(SalesOrderEditService service){
        this.salesOrderEditService = service;
    }

}
