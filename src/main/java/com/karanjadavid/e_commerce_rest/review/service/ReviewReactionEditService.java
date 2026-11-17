package com.karanjadavid.e_commerce_rest.review.service;

import com.karanjadavid.e_commerce_rest.customer.service.CustomerReadService;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.review.entity.ReviewReaction;
import com.karanjadavid.e_commerce_rest.review.form.ReviewReactionEditForm;
import com.karanjadavid.e_commerce_rest.review.form.ReviewReactionRegistrationForm;
import com.karanjadavid.e_commerce_rest.review.repository.ReviewReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewReactionEditService extends BaseJpaRepoEditService<ReviewReaction, ReviewReactionRepository> {

    private ReviewReadService reviewReadService;

    private CustomerReadService customerReadService;

    public ReviewReaction registerReviewReaction(ReviewReactionRegistrationForm form){
        var reaction = new ReviewReaction();
        mapFields(reaction, form);
        reaction = save(reaction, form.getSessionUserId());
        return reaction;
    }

    public ReviewReaction editReviewReaction(String reactionId, ReviewReactionEditForm form){
        var reaction = findByEntityId(reactionId);
        mapFields(reaction, form);
        reaction = save(reaction, form.getSessionUserId());
        return reaction;
    }

    public void mapFields(ReviewReaction reaction, ReviewReactionEditForm form){
        var review = reviewReadService.findByEntityId(form.getReviewEntityId());
        var customer = customerReadService.findByEntityId(form.getCustomerEntityId());
        reaction.setReview(review);
        reaction.setCustomer(customer);
        reaction.setReactionType(form.getReactionType());
    }

    @Autowired
    public void setReviewReadService(ReviewReadService service){
        this.reviewReadService = service;
    }

    @Autowired
    public void setCustomerReadService(CustomerReadService service){
        this.customerReadService = service;
    }

}
