package com.karanjadavid.e_commerce_rest.cart.service;

import com.karanjadavid.e_commerce_rest.cart.entity.CartItem;
import com.karanjadavid.e_commerce_rest.cart.form.CartItemEditForm;
import com.karanjadavid.e_commerce_rest.cart.form.CartItemRegistrationForm;
import com.karanjadavid.e_commerce_rest.cart.repository.CartItemRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemEditService extends BaseJpaRepoEditService<CartItem, CartItemRepository> {

    private ProductReadService productReadService;

    public CartItem registerCartItem(CartItemRegistrationForm form){
        var item = new CartItem();
        mapFields(item, form);
        item = save(item, form.getSessionUserId());
        return item;
    }

    public CartItem editCartItem(String itemId, CartItemEditForm form){
        var item = findByEntityId(itemId);
        mapFields(item, form);
        item = save(item, form.getSessionUserId());
        return item;
    }

    private void mapFields(CartItem item, CartItemEditForm form){
        var product = productReadService.findByEntityId(form.getProductEntityId());

        item.setProduct(product);
        item.setQuantity(form.getQuantity());
    }

    @Autowired
    public void setProductReadService(ProductReadService service){
        this.productReadService = service;
    }

}
