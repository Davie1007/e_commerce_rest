package com.karanjadavid.e_commerce_rest.feedback.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductReaction extends BaseJpaEntity {

    @ManyToOne
    private Product product;

    @OneToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

}
