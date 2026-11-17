package com.karanjadavid.e_commerce_rest.review.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.review.entity.Review;
import com.karanjadavid.e_commerce_rest.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewReadService extends BaseJpaRepoReadService<Review, ReviewRepository> {
}
