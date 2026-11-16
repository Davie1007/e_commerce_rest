package com.karanjadavid.e_commerce_rest.cart.view;

import com.karanjadavid.e_commerce_rest.cart.entity.CartItem;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.product.entity.Product;

public class CartItemView extends BaseView<CartItem> {
    public CartItemView(CartItem entity) {
        super(entity);
    }
    public Product getProduct(){ return entity.getProduct(); }
    public int getQuantity(){ return entity.getQuantity(); }
}
