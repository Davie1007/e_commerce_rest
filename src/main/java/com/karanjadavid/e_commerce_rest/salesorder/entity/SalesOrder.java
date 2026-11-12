package com.karanjadavid.e_commerce_rest.salesorder.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SalesOrder extends BaseJpaEntity {

    @ManyToOne
    private Customer customer;

    private List<SaleOrderItem> saleOrderItems;

}
