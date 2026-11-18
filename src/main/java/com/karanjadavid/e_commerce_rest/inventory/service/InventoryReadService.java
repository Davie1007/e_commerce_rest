package com.karanjadavid.e_commerce_rest.inventory.service;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.inventory.repository.InventoryRepository;
import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class InventoryReadService extends BaseJpaRepoReadService<Inventory, InventoryRepository> {

    public Page<Inventory> listInventory(BaseFetchForm form){
        var spec = repository.notDeleted();

        return repository.findAll(
                spec,
                repository.defaultPageable(form)
        );
    }

}
