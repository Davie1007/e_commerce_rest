package com.karanjadavid.e_commerce_rest.salesorder.view;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.Address;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SaleOrderItem;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;

import java.util.List;

public class SalesOrderView extends BaseView<SalesOrder> {
    public SalesOrderView(SalesOrder entity) {
        super(entity);
    }

    public Customer getCustomer(){ return entity.getCustomer(); }

    public List<SaleOrderItem> getSaleOrderItems(){ return entity.getSaleOrderItems(); }

    public Address getAddress(){ return entity.getAddress(); }

}
