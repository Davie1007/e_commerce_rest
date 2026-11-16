package com.karanjadavid.e_commerce_rest.manufacturer.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.manufacturer.entity.Manufacturer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends BaseJpaRepository<Manufacturer> {
}
