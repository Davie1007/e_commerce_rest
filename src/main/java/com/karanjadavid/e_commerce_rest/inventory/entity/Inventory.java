package com.karanjadavid.e_commerce_rest.inventory.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Inventory extends BaseJpaEntity {

    @OneToOne
    private Product product;
    private int quantity;

}
