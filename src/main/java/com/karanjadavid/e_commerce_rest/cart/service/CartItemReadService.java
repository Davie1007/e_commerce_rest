package com.karanjadavid.e_commerce_rest.cart.service;

import com.karanjadavid.e_commerce_rest.cart.entity.CartItem;
import com.karanjadavid.e_commerce_rest.cart.repository.CartItemRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import org.springframework.stereotype.Service;

@Service
public class CartItemReadService extends BaseJpaRepoReadService<CartItem, CartItemRepository> {
}
