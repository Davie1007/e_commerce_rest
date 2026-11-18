package com.karanjadavid.e_commerce_rest.feedback.repository;

import com.karanjadavid.e_commerce_rest.feedback.entity.Rating;
import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository  extends BaseJpaRepository<Rating> {
}
