package com.karanjadavid.e_commerce_rest.salesorder.view;

import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SaleOrderItem;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;

import java.util.List;

public class SalesOrderView extends BaseView<SalesOrder> {
    public SalesOrderView(SalesOrder entity) {
        super(entity);
    }

    public String getCustomerName(){ return entity.getCustomer().getName(); }
    public String getCustomerPhoneNumber(){ return entity.getCustomer().getPhoneNumber(); }
    public String getCustomerEmail(){ return entity.getCustomer().getEmail(); }

    public List<SaleOrderItem> getSaleOrderItems(){ return entity.getSaleOrderItems(); }

}
