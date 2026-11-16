package com.karanjadavid.e_commerce_rest.cart.service;

import com.karanjadavid.e_commerce_rest.cart.entity.Cart;
import com.karanjadavid.e_commerce_rest.cart.form.CartEditForm;
import com.karanjadavid.e_commerce_rest.cart.form.CartRegistrationForm;
import com.karanjadavid.e_commerce_rest.cart.repository.CartRepository;
import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartEditService extends BaseJpaRepoEditService<Cart, CartRepository> {

    private CustomerReadService customerReadService;
    private CartItemReadService customerItemReadService;

    public Cart registerCart(CartRegistrationForm form){
        var cart = new Cart();
        mapFields(cart, form);
        cart = save(cart, form.getSessionUserId());
        return cart;
    }

    public Cart editCart(String cartId, CartEditForm form){
        var cart = findByEntityId(cartId);
        mapFields(cart, form);
        cart = save(cart, form.getSessionUserId());
        return cart;
    }

    private void mapFields(Cart cart, CartEditForm form){
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());

        cart.setCustomer(customer);
        for(var cartItemEntityId: form.getCartItemsEntityId()){
            var cartItem = customerItemReadService.findByEntityId(cartItemEntityId);
            cart.getCartItems().add(cartItem);
        }

    }

    @Autowired
    public void setCustomerReadService(CustomerReadService service){
        this.customerReadService = service;
    }

    @Autowired
    public void setCustomerItemReadService(CartItemReadService service){
        this.customerItemReadService = service;
    }

}
