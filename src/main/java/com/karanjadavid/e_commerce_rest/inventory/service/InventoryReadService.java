package com.karanjadavid.e_commerce_rest.inventory.service;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.inventory.repository.InventoryRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import org.springframework.stereotype.Service;

@Service
public class InventoryReadService extends BaseJpaRepoReadService<Inventory, InventoryRepository> {
}
