package com.karanjadavid.e_commerce_rest.review.service;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import com.karanjadavid.e_commerce_rest.review.entity.Review;
import com.karanjadavid.e_commerce_rest.review.form.ReviewEditForm;
import com.karanjadavid.e_commerce_rest.review.form.ReviewRegistrationForm;
import com.karanjadavid.e_commerce_rest.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewEditService  extends BaseJpaRepoEditService<Review, ReviewRepository> {

    private ProductReadService productReadService;
    private CustomerReadService customerReadService;

    public Review registerReview(ReviewRegistrationForm form){
        var review = new Review();
        mapFields(review, form);
        review = save(review, form.getSessionUserId());
        return review;
    }

    public Review editReview(String reviewId, ReviewEditForm form){
        var review = findByEntityId(reviewId);
        mapFields(review, form);
        review = save(review, form.getSessionUserId());
        return review;
    }

    private void mapFields(Review review, ReviewEditForm form){
        var product = productReadService.findByEntityId(form.getProductEntityId());
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());
        review.setProduct(product);
        review.getCustomer().add(customer);
        review.setText(form.getText());
    }

    @Autowired
    public void setCustomerReadService(CustomerReadService service){
        this.customerReadService = service;
    }

    @Autowired
    public void setProductReadService(ProductReadService service){
        this.productReadService = service;
    }

}
