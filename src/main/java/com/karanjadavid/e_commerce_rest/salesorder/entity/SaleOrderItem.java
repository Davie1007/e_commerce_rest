package com.karanjadavid.e_commerce_rest.salesorder.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class SaleOrderItem extends BaseJpaEntity {

    @OneToOne
    private Product product;

    private BigDecimal price;

    private int quantity;

}
