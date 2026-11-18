package com.karanjadavid.e_commerce_rest.product.entity;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.manufacturer.entity.Manufacturer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Product extends BaseJpaEntity {

    private String name;

    private BigDecimal price;

    private List<String> imageUrls = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "product_features",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @MapKeyColumn(name = "feature_name")
    @Column(name = "feature_value")
    private Map<String, String> features = new HashMap<>();

    @OneToOne
    private Manufacturer manufacturer;

}
