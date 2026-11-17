package com.karanjadavid.e_commerce_rest.review.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.review.entity.ReviewReaction;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewReactionRepository extends BaseJpaRepository<ReviewReaction> {
}
