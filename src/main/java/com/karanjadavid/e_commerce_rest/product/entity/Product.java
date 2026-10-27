package com.karanjadavid.e_commerce_rest.product.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseJpaEntity {

    private String name;

    public Product() {
        
    }

}
