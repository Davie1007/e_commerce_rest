package com.karanjadavid.e_commerce_rest.cart.entity;

import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Cart extends BaseJpaEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer Customer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

}
