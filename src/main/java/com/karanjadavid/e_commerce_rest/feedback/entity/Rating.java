package com.karanjadavid.e_commerce_rest.feedback.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating extends BaseJpaEntity {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    private short rating;

}
