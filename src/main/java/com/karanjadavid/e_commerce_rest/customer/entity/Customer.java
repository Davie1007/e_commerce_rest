package com.karanjadavid.e_commerce_rest.customer.entity;

import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;
import com.karanjadavid.e_commerce_rest.systemuser.entity.SystemUser;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends SystemUser {

    @OneToMany
    private List<SalesOrder> salesOrders;

}
