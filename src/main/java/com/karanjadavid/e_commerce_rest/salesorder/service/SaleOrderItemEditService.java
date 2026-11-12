package com.karanjadavid.e_commerce_rest.salesorder.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SaleOrderItem;
import com.karanjadavid.e_commerce_rest.salesorder.repository.SalesOrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderItemEditService extends BaseJpaRepoEditService<SaleOrderItem, SalesOrderItemRepository> {
}
