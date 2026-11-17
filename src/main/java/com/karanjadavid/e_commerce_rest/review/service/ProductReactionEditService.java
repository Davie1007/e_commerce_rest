package com.karanjadavid.e_commerce_rest.review.service;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import com.karanjadavid.e_commerce_rest.review.entity.ProductReaction;
import com.karanjadavid.e_commerce_rest.review.form.ProductReactionEditForm;
import com.karanjadavid.e_commerce_rest.review.form.ProductReactionRegistrationForm;
import com.karanjadavid.e_commerce_rest.review.repository.ProductReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReactionEditService extends BaseJpaRepoEditService<ProductReaction, ProductReactionRepository> {

    private ProductReadService productReadService;
    private CustomerReadService customerReadService;

    public ProductReaction registerProductReaction(ProductReactionRegistrationForm form){
        var reaction = new ProductReaction();
        mapFields(reaction, form);
        reaction = save(reaction, form.getSessionUserId());
        return reaction;
    }

    public ProductReaction editProductReaction(String productReaction, ProductReactionEditForm form){
        var reaction = findByEntityId(productReaction);
        mapFields(reaction, form);
        reaction = save(reaction, form.getSessionUserId());
        return reaction;
    }

    public void mapFields(ProductReaction reaction, ProductReactionEditForm form){
        var product = productReadService.findByEntityId(form.getProductEntityId());
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());
        reaction.setProduct(product);
        reaction.setCustomer(customer);
        reaction.setReactionType(form.getReactionType());
    }

    @Autowired
    public void setProductReadService(ProductReadService service){
        this.productReadService = service;
    }

    @Autowired
    public void setCustomerReadService(CustomerReadService service){
        this.customerReadService = service;
    }

}
