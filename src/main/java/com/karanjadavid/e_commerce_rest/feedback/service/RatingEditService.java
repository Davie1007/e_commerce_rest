package com.karanjadavid.e_commerce_rest.feedback.service;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.feedback.entity.Rating;
import com.karanjadavid.e_commerce_rest.feedback.form.RatingEditForm;
import com.karanjadavid.e_commerce_rest.feedback.form.RatingRegistrationForm;
import com.karanjadavid.e_commerce_rest.feedback.repository.RatingRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingEditService extends BaseJpaRepoEditService<Rating, RatingRepository> {

    private ProductReadService productReadService;
    private CustomerReadService customerReadService;

    public Rating registerRating(RatingRegistrationForm form){
        var rating = new Rating();
        mapFields(rating, form);
        rating = save(rating, form.getSessionUserId());
        return rating;
    }

    private void mapFields(Rating rating, RatingEditForm form){
        var product = productReadService.findByEntityId(form.getProductEntityId());
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());
        rating.setProduct(product);
        rating.setCustomer(customer);
        rating.setRating(form.getRating());
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
