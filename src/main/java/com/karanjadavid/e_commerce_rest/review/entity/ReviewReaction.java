package com.karanjadavid.e_commerce_rest.review.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ReviewReaction extends BaseJpaEntity {

    @ManyToOne
    private Review review;

    @OneToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
}
