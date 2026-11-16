package com.karanjadavid.e_commerce_rest.product.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.manufacturer.entity.Manufacturer;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseJpaEntity {

    private String name;

    private BigDecimal price;

    private List<String> imageUrls = new ArrayList<>();

    @OneToOne
    private Manufacturer manufacturer;

}
