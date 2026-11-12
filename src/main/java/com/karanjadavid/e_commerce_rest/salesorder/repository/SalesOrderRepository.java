package com.karanjadavid.e_commerce_rest.salesorder.repository;

import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends BaseJpaRepository<SalesOrder> {
}
