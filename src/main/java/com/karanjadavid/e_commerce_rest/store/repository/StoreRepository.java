package com.karanjadavid.e_commerce_rest.store.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.store.entity.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends BaseJpaRepository<Store> {
}
