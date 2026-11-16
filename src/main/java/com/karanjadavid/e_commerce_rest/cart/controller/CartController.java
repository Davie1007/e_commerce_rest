package com.karanjadavid.e_commerce_rest.cart.controller;

import com.karanjadavid.e_commerce_rest.cart.form.CartEditForm;
import com.karanjadavid.e_commerce_rest.cart.form.CartRegistrationForm;
import com.karanjadavid.e_commerce_rest.cart.service.CartEditService;
import com.karanjadavid.e_commerce_rest.cart.view.CartView;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/carts")
public class CartController {

    private CartEditService cartEditService;

    @PostMapping("/register")
    public EntityApiResponse<CartView> registerCart(@RequestBody CartRegistrationForm form, Locale locale){
        var cart = cartEditService.registerCart(form);
        return new EntityApiResponse<>(
                Message.get("cart.registration.success", locale),
                new CartView(cart)
        );
    }

    @PutMapping("/edit/{cartId}")
    public EntityApiResponse<CartView> editCart(@PathVariable String cartId, @RequestBody CartEditForm form, Locale locale){
        var cart = cartEditService.editCart(cartId, form);
        return new EntityApiResponse<>(
                Message.get("cart.edit.success", locale),
                new CartView(cart)
        );
    }

    @Autowired
    public void setCartEditService(CartEditService service){
        this.cartEditService = service;
    }

}
