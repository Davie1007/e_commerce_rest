package com.karanjadavid.e_commerce_rest.review.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Review extends BaseJpaEntity {

    @ManyToOne
    private Product product;

    @OneToMany
    private List<Customer> customer;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_review_id")
    private Review parentReview;

    @OneToMany(mappedBy = "parentReview", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> replies = new ArrayList<>();

    public void addReply(Review reply) {
        replies.add(reply);
        reply.setParentReview(this);
    }
}

