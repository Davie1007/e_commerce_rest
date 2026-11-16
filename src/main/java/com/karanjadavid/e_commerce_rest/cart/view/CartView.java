package com.karanjadavid.e_commerce_rest.cart.view;

import com.karanjadavid.e_commerce_rest.cart.entity.Cart;
import com.karanjadavid.e_commerce_rest.cart.entity.CartItem;
import com.karanjadavid.e_commerce_rest.customer.entity.Customer;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;

import java.util.List;

public class CartView extends BaseView<Cart> {
    public CartView(Cart entity) {
        super(entity);
    }

    public Customer getCustomer(){ return entity.getCustomer(); }
    public List<CartItem> getCartItems(){ return entity.getCartItems(); }
}
