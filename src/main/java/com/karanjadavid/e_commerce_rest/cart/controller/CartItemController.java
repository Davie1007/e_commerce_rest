package com.karanjadavid.e_commerce_rest.cart.controller;

import com.karanjadavid.e_commerce_rest.cart.form.CartItemEditForm;
import com.karanjadavid.e_commerce_rest.cart.form.CartItemRegistrationForm;
import com.karanjadavid.e_commerce_rest.cart.service.CartItemEditService;
import com.karanjadavid.e_commerce_rest.cart.view.CartItemView;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("cart-items")
public class CartItemController {

    private CartItemEditService cartItemEditService;

    @PostMapping("/register")
    public EntityApiResponse<CartItemView> registerCartItem(@RequestBody CartItemRegistrationForm form, Locale locale){
        var item = cartItemEditService.registerCartItem(form);
        return new EntityApiResponse<>(
                Message.get("cart.item.registration.success", locale),
                new CartItemView(item)
        );
    }

    @PutMapping("/edit/{itemId}")
    public EntityApiResponse<CartItemView> editCartItem(@PathVariable String itemId, @RequestBody CartItemEditForm form, Locale locale){
        var item = cartItemEditService.editCartItem(itemId, form);
        return new EntityApiResponse<>(
                Message.get("cart.item.edit.success", locale),
                new CartItemView(item)
        );
    }

    @Autowired
    public void setCartItemEditService(CartItemEditService service){
        this.cartItemEditService = service;
    }

}
