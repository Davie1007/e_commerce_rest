package com.karanjadavid.e_commerce_rest.cart.service;

import com.karanjadavid.e_commerce_rest.cart.entity.Cart;
import com.karanjadavid.e_commerce_rest.cart.repository.CartRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import org.springframework.stereotype.Service;

@Service
public class CartReadService extends BaseJpaRepoReadService<Cart, CartRepository> {
}
