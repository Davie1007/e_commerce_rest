package com.karanjadavid.e_commerce_rest.feedback.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.feedback.entity.Review;
import com.karanjadavid.e_commerce_rest.feedback.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewReadService extends BaseJpaRepoReadService<Review, ReviewRepository> {
}
